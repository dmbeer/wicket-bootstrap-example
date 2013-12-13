wicket-bootstrap-example
========================

For This example to work you will need to clone the [wicket-bootstrap](https://github.com/l0rdn1kk0n/wicket-bootstrap) project and compile it using maven.

- git clone https://github.com/l0rdn1kk0n/wicket-bootstrap.git
- navigate to the directory where you cloned the above project
- git checkout bootstrap3 (to get the bootstrap3 branch)
- then in the current directory run mvn clean install

This will install wicket-bootstrap to your local maven repo.

Then do a mvn clean install on the above project and deploy to a container of your choice.
Access the application at http://localhost:8080/wicket-bootstrap-example
