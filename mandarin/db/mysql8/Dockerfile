FROM mysql:latest

# set default character set and collation
RUN echo "[mysqld]" >> /etc/mysql/conf.d/charset.cnf
RUN echo "character-set-server=utf8mb4" >> /etc/mysql/conf.d/charset.cnf
RUN echo "collation-server=utf8mb4_unicode_ci" >> /etc/mysql/conf.d/charset.cnf

# set default client character set and collation
RUN echo "[client]" >> /etc/mysql/conf.d/charset.cnf
RUN echo "default-character-set=utf8mb4" >> /etc/mysql/conf.d/charset.cnf

# set default character set and collation for mysqldump
RUN echo "[mysqldump]" >> /etc/mysql/conf.d/charset.cnf
RUN echo "default-character-set=utf8mb4" >> /etc/mysql/conf.d/charset.cnf

# Copy custom SQL scripts into the container
COPY init-scripts/ /docker-entrypoint-initdb.d/
COPY m.sh m.sh

ENV MYSQL_DATABASE=mandarin

# Expose port 3306
EXPOSE 3306