module service
{
    requires email;
    requires repository;
    requires spring.data.jpa;
    exports service.doctor
}