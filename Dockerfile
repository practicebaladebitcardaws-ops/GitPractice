FROM node AS build
ARG var=/app
WORKDIR ${vare}
COPY package*.json .
RUN npm ci
COPY . .
FROM nginx
WORKDIR /usr/share/nginx/html
COPY --from=build build/${vare} .
EXPOSE 8080
CMD ["nginx" , "-g" , "daemon off;"]
