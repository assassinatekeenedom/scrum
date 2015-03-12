package com.keene.mepbm.natural.science.observation;

/**
 *
 * The first requirement for any observation is a name to identify it, or names identifying the things being observed.
 *
 * A name is a basic requirement for any observable entity.
 *
 */
public interface Name {

    public String getName();

    public enum Meta{
        DELIMITER("."),
        PERCEPTION("PERCEPTION"),
        NAME("NAME"),
        VALUE("VALUE"),
        GATEKEEPER("GATEKEEPER"),
        CURRENT_CONTEXT("CURRENT_CONTEXT"),
        PARENT_CONTEXT("PARENT_CONTEXT");

        private final String name;

        private Meta(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }
    }

}
