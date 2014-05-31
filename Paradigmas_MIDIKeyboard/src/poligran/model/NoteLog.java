package poligran.model;

import java.io.Serializable;

public class NoteLog implements Serializable
{
	/**
	 * long
	 * Represents: 
	 */
	private static final long serialVersionUID = -7129499227325822491L;
	private String note;
	private long time;

	public NoteLog(String note, long time)
	{
		this.note = note;
		this.time = time;
	}

	public String getNote()
	{
		return note;
	}

	public void setNote(String note)
	{
		this.note = note;
	}

	public long getTime()
	{
		return time;
	}

	public void setTime(long time)
	{
		this.time = time;
	}
	public String toString()
	{
		return this.note+":"+this.time+"\n";
	}
}
