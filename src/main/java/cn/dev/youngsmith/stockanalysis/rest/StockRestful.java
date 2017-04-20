package cn.dev.youngsmith.stockanalysis.rest;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import cn.dev.youngsmith.stockanalysis.juhe.schedule.Schedule;

@Path("/stock")
public class StockRestful {
	@Inject
	private Schedule schedule;

	public Schedule getSchedule() {
		return schedule;
	}

	public void setSchedule(Schedule schedule) {
		this.schedule = schedule;
	}

	@Path("/postJob")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public boolean postJob() {
		schedule.run();
		return true;
	}
}
