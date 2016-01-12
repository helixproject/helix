# ![Helix](img/Helix.png)

## Installation

To install Helix platform, you will need three hosts: two as Docker servers,
and one to host the main application. Every host should satisfy following
requirements (at least for the Docker servers):

* Linux kernel v3.11 or higher (Ubuntu 15.04 Vivid Vervet or higher is recommended)
* 4GB of RAM

### Prepare the Docker servers

On both servers, install:

* Docker experimental version (>=1.10.0-dev)
* CRIU 1.8

Make sure that SSH key are exchanged bewteen the two servers.

Create the filesystem for Helix:

    /helix
    └── data-volume

### Install the Webapp

First, you have to create filesystem for Helix.
Copy the [helix](install/filesystem/helix/) folder to your the root directory
(/) of your web server. Your filesystem should like this:

    /helix
    ├── demo-webapps
    │   └── DemoWebapp.war
    ├── scripts
    │   ├── checkStats.sh
    │   ├── CreateContainerDataVolume.sh
    │   ├── CreateContainer.sh
    │   ├── CreateUserDataVolume.sh
    │   ├── uploadWebApp.sh
    ├── servers
    │   ├── free.conf
    │   ├── host.conf
    │   ├── premium.conf
    └── tmp

On the webserver, make sure that you have:

* JRE 1.7 (or higher)
* Tomcat 7 (or higher)
* MySQL 5.5 (or higher)

Connect to your MySQL server, and create a database for Helix:

    create database helix

Finally, copy [helix.web.war](install/helix.web.war) into your Tomcat /webapps
folder.

## Authors

    ~ Helix Team
      Github: https://github.com/helixproject/helix
