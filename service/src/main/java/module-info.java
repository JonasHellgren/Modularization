open module service
{
    requires email;
    requires repository;
    requires spring.beans;
    requires spring.context;
    requires java.annotation;
    requires domain;
    //requires spring.data.jpa;
    exports service.doctor;
}