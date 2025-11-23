# Use Tomcat 10.1 with Java 17
FROM tomcat:10.1-jdk21

# Remove default webapps to keep image clean
RUN rm -rf /usr/local/tomcat/webapps/*

# Copy your WAR into Tomcat as the ROOT application
# Note: ensure Root.war is present in build context (same folder as Dockerfile)
COPY Root.war /usr/local/tomcat/webapps/ROOT.war

# Expose Tomcat port
EXPOSE 8080

# Start Tomcat
CMD ["catalina.sh", "run"]
