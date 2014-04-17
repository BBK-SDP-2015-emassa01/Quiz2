Quiz2
=====

AssignmentIII PiJ see 'Quiz' for earlier version control

Server README
=============

The Server is launched first and does not close down. The server remains running and listening for input. The clients however, do close down upon request.
All data for the Quiz Server is held in a class called QuizServer and it is this class that is serlialized upon Client shutdown, to a file called ‘quizData.txt’. The QuizServer, when constructed, deserializes the quizData.txt file and restores the variables to their state before shutdown.

The details below assume the user is at the QuizProject directory level, and using the quiz from the command line.

To run the server:
→ Compile all classes: 
javac QuizProject/Servers/*.java
javac QuizProject/PlayerClient/*.java
javac QuizProject/SetupClient/*.java

→ Create the stub: rmic QuizProject/Servers/QuizServerData

→ Run the security policy: 
java -Djava.security.policy=server.policy QuizProject.Servers.QuizServerLauncher


Setup CLIENT README
===================

The Setup client should be launched second (at least the first time the system is used), as Quizzes will need to be ‘set-up’ and added to the quiz list before a player requests to play a quiz. Once a quiz has been set up, a player client can play this quiz. The Setup Client can do the following:

→ ADD A NEW QUIZ.

→ LIST THE 'ACTIVE QUIZZES' LIST.

→ LIST QUESTIONS OF A SPECIFIED QUIZ ID

→ LIST OF 'ACTIVE QUIZ' QUESTIONS, INCLUDING THEIR CORRECT MULTIPLE CHOICE ANSWERS.

→ REVEAL A WINNER OF AN EXISTING QUIZ. 

→ CLOSE A QUIZ DOWN AND REMOVE IT FROM THE ACTIVE QUIZ LIST.

→ RETURN THE 'CLOSED QUIZZES' LIST.

→ SAVE THE QUIZ LIST.

→ CLOSE DOWN THE SYSTEM.

To run the Set-Up Client, run the following from the command line once the Server is launched.

java -Djava.security.policy=server.policy QuizProject.SetupClient.QuizSetupClients


Player CLIENT README
====================

The Player client can be launched once there are quizzes to play. The Player Client enters a player name, should this player be a winner, this name will be stored alongside the high score for a quiz. Once the player enters their player name, a list of available quiz names appear along with their Quiz ID.
The Player client can do the following: 
→ PLAY A QUIZ (by selecting this option and entering the Quiz ID).

→ REVEAL A WINNER (by selecting this option and entering the Quiz ID).

→ EXIT THE PLAYER CLIENT SETUP BY TYPING ‘END’ WHEN THE MENU APPEARS (AUTOMATIC SAVE).

To run the Player Client, run the following from the command line once the Server is launched.

java -Djava.security.policy=server.policy QuizProject.PlayerClient.QuizPlayerClient 


TroubleShooting!
================
--> If you receive Errors such as:
Error: Could not find or load main class <Name of Class> then you can try to precede the Class name with the path to the class file, for example for a class in the Server package 'QuizProject.Servers.<Name of Class>'

--> The server.policy must be **** at the level of the QuizProject file **** (as it is in the repository on GitHub).


