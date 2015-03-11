package assassinate;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Filter;
import org.apache.logging.log4j.core.Layout;
import org.apache.logging.log4j.core.LoggerContext;
import org.apache.logging.log4j.core.appender.SocketAppender;
import org.apache.logging.log4j.core.config.AppenderRef;
import org.apache.logging.log4j.core.config.Configuration;
import org.apache.logging.log4j.core.config.LoggerConfig;
import org.apache.logging.log4j.core.config.Property;
import org.apache.logging.log4j.core.net.ssl.SslConfiguration;
import org.apache.logging.log4j.message.FormattedMessage;

public class VirtualClient implements Runnable {

    private String observer;
    private String name = "WWW13371";
    private String domain = "localhost";
    private int port = 13371;
    private int reconnectDelay = 1000;
    private String protocol = "TCP";
    private SslConfiguration ssl = null;
    private boolean immediateFail = true;
    private boolean immediateFlush = true;
    private boolean ignoreExceptions = true;
    private boolean additive = false;
    private boolean includeLocation = true;
    private String advertise = null;
    private Layout layout = null;
    private Filter filter = null;
    private Property[] properties = null;
    private AppenderRef[] appender;
    private Configuration loggerConfig = null;
    private Filter loggerFilter = null;
    private Level level = Level.DEBUG;

    @Override
    public String toString() {
        return "<html><title>Hello World!</title><script type='text/javascript' src='js/script.js'></script><body>You Did It!</body></html>";
    }

    @Override
    public void run() {
        LoggerContext ctx = (LoggerContext) LogManager.getContext(false);
        Configuration config = ctx.getConfiguration();
        SocketAppender socket = SocketAppender.createAppender(domain, Integer.toString(port), protocol, ssl, Integer.toString(reconnectDelay), Boolean.toString(immediateFail), name, Boolean.toString(immediateFlush), Boolean.toString(ignoreExceptions), layout, filter, advertise, config);
        LoggerConfig logger = LoggerConfig.createLogger(Boolean.toString(additive), level, observer, Boolean.toString(includeLocation), appender, properties, loggerConfig, loggerFilter);
        socket.start();
        logger.addAppender(socket, level, null);
        config.addLogger(getClass().getCanonicalName(), logger);
        ctx.updateLoggers();
        LogManager.getLogger().log(level, new FormattedMessage(messagePattern, messageArguments));
        socket.stop();
    }

    private String messagePattern = "{}";
    private Object[] messageArguments = null;

    public String getMessagePattern() {
        return messagePattern;
    }

    public void setMessagePattern(String messagePattern) {
        this.messagePattern = messagePattern;
    }

    public Object[] getMessageArguments() {
        return messageArguments;
    }

    public void setMessageArguments(Object[] messageArguments) {
        this.messageArguments = messageArguments;
    }

    public VirtualClient() {
        observer = getClass().getCanonicalName();
        appender = new AppenderRef[]{AppenderRef.createAppenderRef(name, level, null)};
    }

    public String getObserver() {
        return observer;
    }

    public void setObserver(String observer) {
        this.observer = observer;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDomain() {
        return domain;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public int getReconnectDelay() {
        return reconnectDelay;
    }

    public void setReconnectDelay(int reconnectDelay) {
        this.reconnectDelay = reconnectDelay;
    }

    public String getProtocol() {
        return protocol;
    }

    public void setProtocol(String protocol) {
        this.protocol = protocol;
    }

    public SslConfiguration getSsl() {
        return ssl;
    }

    public void setSsl(SslConfiguration ssl) {
        this.ssl = ssl;
    }

    public boolean isImmediateFail() {
        return immediateFail;
    }

    public void setImmediateFail(boolean immediateFail) {
        this.immediateFail = immediateFail;
    }

    public boolean isImmediateFlush() {
        return immediateFlush;
    }

    public void setImmediateFlush(boolean immediateFlush) {
        this.immediateFlush = immediateFlush;
    }

    public boolean isIgnoreExceptions() {
        return ignoreExceptions;
    }

    public void setIgnoreExceptions(boolean ignoreExceptions) {
        this.ignoreExceptions = ignoreExceptions;
    }

    public boolean isAdditive() {
        return additive;
    }

    public void setAdditive(boolean additive) {
        this.additive = additive;
    }

    public boolean isIncludeLocation() {
        return includeLocation;
    }

    public void setIncludeLocation(boolean includeLocation) {
        this.includeLocation = includeLocation;
    }

    public String getAdvertise() {
        return advertise;
    }

    public void setAdvertise(String advertise) {
        this.advertise = advertise;
    }

    public Layout getLayout() {
        return layout;
    }

    public void setLayout(Layout layout) {
        this.layout = layout;
    }

    public Filter getFilter() {
        return filter;
    }

    public void setFilter(Filter filter) {
        this.filter = filter;
    }

    public Property[] getProperties() {
        return properties;
    }

    public void setProperties(Property[] properties) {
        this.properties = properties;
    }

    public Level getLevel() {
        return level;
    }

    public void setLevel(Level level) {
        this.level = level;
    }

    public AppenderRef[] getAppender() {
        return appender;
    }

    public void setAppender(AppenderRef[] appender) {
        this.appender = appender;
    }

    public Configuration getLoggerConfig() {
        return loggerConfig;
    }

    public void setLoggerConfig(Configuration loggerConfig) {
        this.loggerConfig = loggerConfig;
    }

    public Filter getLoggerFilter() {
        return loggerFilter;
    }

    public void setLoggerFilter(Filter loggerFilter) {
        this.loggerFilter = loggerFilter;
    }

}
