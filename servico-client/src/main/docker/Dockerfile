FROM java:8
VOLUME /tmp
ENV TZ=America/Sao_Paulo
ADD servico-client.jar /servico-client.jar
RUN bash -c 'touch /servico-client.jar'
RUN ln -snf /usr/share/zoneinfo/$TZ /etc/localtime && echo $TZ > /etc/timezone
ENTRYPOINT ["java" , "-server","-XX:+CMSParallelRemarkEnabled","-XX:+UseParNewGC" , "-XX:-OmitStackTraceInFastThrow" ,"-XX:SurvivorRatio=2","-XX:+CMSConcurrentMTEnabled", "-XX:CMSMaxAbortablePrecleanTime=10000", "-XX:PermSize=64M","-XX:MaxPermSize=256M", "-XX:-UseAdaptiveSizePolicy" , "-Xmx25g","-jar","/servico-client.jar"]