package org.apache.catalina.startup;

import org.apache.catalina.Container;
import org.apache.tomcat.util.digester.Rule;
import org.xml.sax.Attributes;

/**
 * Rule that sets the parent class loader for the top object on the stack,
 * which must be a <code>Container</code>.
 */

final class SetParentClassLoaderRule extends Rule {

    public SetParentClassLoaderRule(ClassLoader parentClassLoader) {

        this.parentClassLoader = parentClassLoader;

    }

    ClassLoader parentClassLoader = null;

    @Override
    public void begin(String namespace, String name, Attributes attributes)
            throws Exception {

        if (digester.getLogger().isDebugEnabled()) {
            digester.getLogger().debug("Setting parent class loader");
        }

        Container top = (Container) digester.peek();
        top.setParentClassLoader(parentClassLoader);

    }


}
