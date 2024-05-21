module PointSystem {
    requires spring.boot;
    requires spring.boot.autoconfigure;
    requires spring.web;

    opens dk.sdu.mmmi.cbse.microservice to spring.core, spring.beans, spring.context;
}
