package cn.dev.youngsmith.stockanalysis.util;

import java.io.Serializable;

public class Pair<T, U> implements Serializable {
	private static final long serialVersionUID = -5621441954117702499L;
	T t;
	U u;

	protected Pair() {

	}

	public Pair(T t, U u) {
		this.t = t;
		this.u = u;
	}

	public T first() {
		return t;
	}

	public U second() {
		return u;
	}

	public U second(U value) {
		u = value;
		return u;
	}

	public T first(T value) {
		t = value;
		return t;
	}

	public void set(T t, U u) {
		this.t = t;
		this.u = u;
	}

	@Override
	public String toString() {
		StringBuilder b = new StringBuilder("P[");
		b.append((t != null) ? t.toString() : "null");
		b.append(":");
		b.append((u != null) ? u.toString() : "null");
		b.append("]");
		return b.toString();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((t == null) ? 0 : t.hashCode());
		result = prime * result + ((u == null) ? 0 : u.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof Pair)) {
			return false;
		}
		Pair<?, ?> that = (Pair<?, ?>) obj;
		return (t != null ? t.equals(that.t) : that.t == null) && (u != null ? u.equals(that.u) : that.u == null);
	}

}
