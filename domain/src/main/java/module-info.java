open module domain
{
    exports domain.models;
    exports domain.settings;
    exports domain.utils;

    requires static lombok;
    requires junit;
    requires commons.math3;

}