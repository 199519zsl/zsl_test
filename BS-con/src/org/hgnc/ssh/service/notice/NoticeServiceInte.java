package org.hgnc.ssh.service.notice;

import java.util.List;

import org.hgnc.ssh.bean.Notice;

public interface NoticeServiceInte {
	public void add(Notice t);
	public void delete(String id);
	public void update(Notice t);
	public Notice getById(String id);
	public List<Notice> getAll();
}
