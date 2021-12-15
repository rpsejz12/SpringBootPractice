package com.kim.app.model.page;

import com.kim.app.model.movie.MovieVO;

public interface PageService {
	public PageVO paging(PageVO pvo,MovieVO mvo, String mtype, String search, String table);
}
