package com.sparta.dominic.dungeonsanddragons5echaractermanager.utill;

public class DnD5eAPI {
    public static final String URL = "https://www.dnd5eapi.co/api";

    public static class Race {
        public static final String URL = DnD5eAPI.URL + "/races";
    }

    public static class Class {
        public static final String URL = DnD5eAPI.URL + "/classes";
    }

    public static class Proficiency {
        public static final String URL = DnD5eAPI.URL + "/proficiencies";
    }

    public static class Trait {
        public static final String URL = DnD5eAPI.URL + "/traits";
    }
}
