package cn.dev.youngsmith.stockanalysis.util;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.NoSuchProviderException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.mail.internet.MimeUtility;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

public class MailSender {
	private Properties props;
	private static String sender = "shiyang@internetware.cn";
	private static String smtpHost = "smtp.internetware.cn";
	private static String passwd = "ShiYang0511";

	private static String receiver = "1347908776@qq.com";

	private static Logger log = Logger.getLogger(MailSender.class);

	private MailSender(String smtpHost, String user, String passwd, boolean auth) {
		props = new Properties();
		props.put("mail.smtp.host", smtpHost);
		if (StringUtils.isNotBlank(user)) {
			props.put("mail.smtp.user", user);
			props.put("mail.smtp.auth", String.valueOf(auth));
		} else {
			props.put("mail.smtp.auth", "false");
		}
		if (StringUtils.isNotBlank(passwd)) {
			props.put("mail.smtp.password", passwd);
		} else {
			props.put("mail.smtp.password", "");
		}
	}

	public static void sendEmail(String content) throws Exception {
		StringBuilder sb = new StringBuilder();
		sb.append("亲爱的石洋，<br/><br/>");
		sb.append("&nbsp;&nbsp;您好，这是您需要的信息，请即时操作：" + content + "<br/><br/>");
		sb.append("&nbsp;&nbsp;我们公司将一如既往、热忱的为您服务！<br/><br/>");
		sb.append("谢谢");
		content = sb.toString();
		String subject = "重大操作";
		EMail email = new EMail(sender, subject, receiver);
		email.setAttachPath(null);
		email.setMimeType(EMail.MimeTypeEnum.HTML);
		email.setContent(content);
		new MailSender(smtpHost, sender, passwd, true).sendMail(email);
	}

	/**
	 * send mail to target receiver, content can be plain text or html, can also
	 * add attachment
	 * 
	 * @param email
	 * @throws Exception
	 */
	private void sendMail(EMail email) throws Exception {
		checkData(email);
		try {
			// instance mail session and mail message
			Session session = Session.getInstance(props, null);
			MimeMessage msg = new MimeMessage(session);

			// set mail message required basic field: sender, subject and send
			// time
			setMailBasic(email, msg);

			// set mail content and attachments
			setMailBody(email, msg);
			msg.saveChanges();

			// send out email
			sendOutMail(msg, session);
		} catch (Exception exp) {
			log.error("send mail meet error", exp);
			throw new Exception("send mail meet error:" + exp.getMessage());
		}
	}

	private void checkData(EMail email) {
		if (email == null)
			throw new IllegalArgumentException("please privide mail data!");

		if (email.getToAddr() == null || email.getToAddr().length == 0)
			throw new IllegalArgumentException("please privide mail receiver list!");

		// some mail server forbid empty subject and empty content
		if (email.getSubject() == null)
			email.setSubject("from " + email.getFromAddr());

		if (email.getContent() == null)
			email.setContent("from " + email.getFromAddr());
	}

	private void setMailBasic(EMail email, MimeMessage msg) throws MessagingException, AddressException {
		msg.setFrom(new InternetAddress(email.getFromAddr()));
		msg.setSubject(email.getSubject());
		msg.setSentDate(new Date());

		// resolve receiver address to InternetAddress
		log.info("make receiver list ...");
		InternetAddress[] toAddress = new InternetAddress[email.getToAddr().length];
		for (int i = 0; i < email.getToAddr().length; i++)
			toAddress[i] = new InternetAddress(email.getToAddr()[i]);
		msg.setRecipients(Message.RecipientType.TO, toAddress);

		// resolve CC address to InternetAddress
		if (email.getCcAddr() != null && email.getCcAddr().length > 0) {
			log.info("make cc list ...");
			InternetAddress[] ccAddress = new InternetAddress[email.getCcAddr().length];
			for (int i = 0; i < email.getCcAddr().length; i++)
				ccAddress[i] = new InternetAddress(email.getCcAddr()[i]);
			msg.setRecipients(Message.RecipientType.CC, ccAddress);
		}
	}

	private void setMailBody(EMail email, MimeMessage msg) throws MessagingException, IOException {
		Multipart allBody = new MimeMultipart();
		MimeBodyPart contentPart = new MimeBodyPart();
		contentPart.setContent(email.getContent(), email.getMimeType().getTypeString());
		allBody.addBodyPart(contentPart);

		if (email.getAttachPath() != null && email.getAttachPath().length > 0) {
			log.info("add attachment ...");
			for (int i = 0; i < email.getAttachPath().length; i++) {
				MimeBodyPart attachPart = new MimeBodyPart();
				attachPart.attachFile(new File(email.getAttachPath()[i]));
				attachPart.setFileName(MimeUtility.encodeText(attachPart.getFileName(), "utf-8", null));
				allBody.addBodyPart(attachPart);
			}
		}
		msg.setContent(allBody);
	}

	private void sendOutMail(MimeMessage msg, Session session) throws NoSuchProviderException, MessagingException {
		Transport transport = null;
		try {
			transport = session.getTransport("smtp");
			transport.connect(props.getProperty("mail.smtp.host"), props.getProperty("mail.smtp.user"),
					props.getProperty("mail.smtp.password"));
			transport.sendMessage(msg, msg.getAllRecipients());
			transport.close();
			log.info("completed send mail " + msg.getSubject() + " to " + msg.getAllRecipients()[0] + "...");
		} finally {
			if (transport != null)
				transport.close();
		}
	}
}
