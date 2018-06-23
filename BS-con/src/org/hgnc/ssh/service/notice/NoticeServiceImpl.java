package org.hgnc.ssh.service.notice;

import java.util.List;

import javax.annotation.Resource;

import org.hgnc.ssh.bean.Notice;
import org.hgnc.ssh.dao.notice.NoticeDaoInte;
import org.springframework.stereotype.Service;

@Service("noticeService")
public class NoticeServiceImpl implements NoticeServiceInte{
	private NoticeDaoInte noticeDao;
	
	public NoticeDaoInte getNoticeDao() {
		return noticeDao;
	}
	@Resource
	public void setNoticeDao(NoticeDaoInte noticeDao) {
		this.noticeDao = noticeDao;
	}

	public void add(Notice t) {
		this.noticeDao.add(t);
	}

	public void delete(String id) {
		Notice notice = this.getById(id);
		if(notice != null && notice.getNtc_title().length() != 0){
			this.noticeDao.delete(id);
		}
	}

	public List<Notice> getAll() {
		return this.noticeDao.getAll();
	}

	public Notice getById(String id) {
		return this.noticeDao.getById(id);
	}

	public void update(Notice t) {
		this.noticeDao.update(t);
	}

}
