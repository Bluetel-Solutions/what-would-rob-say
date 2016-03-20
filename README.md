# what-would-rob-say
An API created from the DropWizard Framework

# Getting started
First fork this repo to your own github. We should be creating PR's for completed bits of work. Using the IDE of choice (Eclipse, Intellij, Of course if you are brave and comfortable with it you can use a text editor such as sublime or vim.) import the project.

### Running on your local machine
Once you have pulled down the repo you can test this out on your local machine, in terminal type the following to start a server on your machine;

	gradle run

You can then see this at `127.0.0.1:8080`

### Health Checks
To see the results of the health checks (to which we should have a few once the database has been setup) you can go to `127.0.0.1:8081/healthcheck`

# Database
Since the API will be accepting a phrase or an action and returning an appropriate response, we need the following tables:

### Input
- id
- keyword
- type
- created_at
- updated_at

### Response
- id
- input_id
- text
- created_at
- updated_at

These need to have corresponding entity classes, and a migration specified so we can quickly spin up the database on our local machines.
