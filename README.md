# backend-kinoxp
Group Contract Group 5:
Members:
Mathias, Steffen Jacob, Morten
We use teamchat on Discord for internal communication, Jira for project planning
•	Days and times when you plan to meet:
o	Daily scrum: 08:30 at school
o	
•	Where you will meet (at school,  private, or online)
o	Preferable at school 
o	
•	Meeting discipline
o	How to contact the rest of the group if, for some reason, you are prevented from attending on an agreed day: Discord chat
o	If unable to meet it is expected to notify team. Repeatedly failure to communicate 
•	Branching strategy
o	We use a dev and release-branch;
o	Implementation of userstories/Scrumtasks: branch out from dev in a new branch. When merging back into dev the current state must pass verify (backend) and basic smoketest (frontend). 
o	We use approval and pull-requests
o	Dev functions as release candidate and wil be merged into release for deployment.
o	We use github actions and github as buildserver and deploy the release-branch
•	Code Standard:
o	English in code, Java Naming Standard
o	In approval: focus on errorhandling, sanitizing of input and output
o	DOMpurify, XSS prevention
o	Prettier with vscode
•	Roles:
o	PO (outside part): meet for prioritizing sprint backlog and for sprint review
o	Scrum Master: 
