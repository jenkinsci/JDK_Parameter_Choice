package com.datalex.jdkparameter;

import hudson.EnvVars;
import hudson.Extension;
import hudson.Launcher;
import hudson.model.AbstractBuild;
import hudson.model.AbstractProject;
import hudson.model.BuildListener;
import hudson.tasks.BuildWrapper;
import hudson.tasks.BuildWrapperDescriptor;
import jenkins.model.Jenkins;

import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 * User: barisbatiege
 * Date: 6/28/13
 * Time: 11:20 AM
 * To change this template use File | Settings | File Templates.
 */
public class JavaParameterBuildWrapper extends BuildWrapper {

    private String originalJDK;

    public void restoreOriginalJDK(Jenkins jdk){


    }

    @Override
    public Environment setUp(AbstractBuild build, Launcher launcher, BuildListener listener) throws IOException, InterruptedException, IOException {
        String jdkValue = (String)build.getBuildVariables().get("jdk");


        EnvVars env = build.getEnvironment(listener);
        env.overrideAll(build.getBuildVariables());

        boolean success = true;

        return null;

    }

    public String getOriginalJDK() {
        return originalJDK;
    }

    public void setOriginalJDK(String originalJDK) {
        this.originalJDK = originalJDK;
    }


    @Extension
    public static class DescriptorImpl extends BuildWrapperDescriptor {

        @Override
        public String getDisplayName() {
            return "Select JDK to be used";
        }

        @Override
        public boolean isApplicable(AbstractProject<?, ?> item) {
            return true;
        }

    }
}
