package com.skio.services;

import java.util.List;

import com.skio.dto.BugRespDto;
import com.skio.models.Bug;

public interface BugService {

	List<BugRespDto> getAllBugs();

	BugRespDto addBugDetails(BugRespDto newBug);

	String deleteBugDetails(Long bugId);

	BugRespDto getBugDetails(Long bugId);

	BugRespDto updateBugDetails(BugRespDto bug);

}
