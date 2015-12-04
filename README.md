# PCSS-Project

Exam project for the Programming of Complex Software Systems class of 2015
Game is made based on the boardgame Ticket to Ride
Serverside created by Frederik E., Oana D., and Patrick S. (GeneralIssues, Sothisx, and Holt95)

## Libraries in use
Slick2D - http://slick.ninjacave.com/
Used for displaying graphics and creating the gameboard in itself

Kryonet - https://github.com/EsotericSoftware/kryonet
Used for connecting the client and server with either UDP or TCP
More can be read here https://github.com/GeneralIssues/PCSS-Project-Server/wiki/Communication-protocol

## Run Instructions
The project comes in two parts: client and server. 
What you're looking at right now is the SERVER.
The server is used for connecting the clients. 
If you want to play with other people (minimum 2, otherwise it is not really a game)
you will need to download the CLIENT which can be found here:
https://github.com/ludvigsjbb/PCSS-project-client
The server can take a maximum of 5 people and does not need to be hosted together with a client.
Next is a step by step on what to do, to make the server run. 
* The project can be downloaded as a ZIP on the main page
* Unpack the ZIP file to a given folder
* Open the folder as a project in an IDE
* Run the ServerProgram.java (it contains the main)
The server is now open and clients are able to connect

