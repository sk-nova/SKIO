package com.skio.models;

public enum BugStatus {
	OPEN, ASSIGNED, IN_PROGRESS, TESTING, VERIFIED, CLOSED, REOPENED, CANNOT_REPRODUCE, NEED_MORE_INFO
}
/*
 * 
1. Open:
The initial status when a bug is reported but not yet assigned or investigated.

2. Assigned:
The bug has been assigned to a developer or a team for investigation and resolution.

3. In Progress:
The developer is actively working on fixing the bug.

4. Code Review:
The fix is complete, and the code is under review by peers or a lead developer.

5. Testing:
The fixed code is being tested to ensure that the bug is resolved without introducing new issues.

6. Verified:
The bug fix has been successfully tested and verified to be resolved.

7. Closed:
The bug is considered fixed and closed. No further action is required.

8. Reopened:
The bug was closed but has resurfaced or was not fully resolved. It needs further attention.

9. Deferred:
The resolution of the bug is postponed to a future release or sprint.

10. Cannot Reproduce:
The reported issue could not be reproduced, and it is assumed to be non-existent or resolved.

11. Duplicate:
The bug report is a duplicate of another already-reported issue.

12. Need More Information:
Additional information is required from the reporter or the developer to proceed with the investigation.

 */