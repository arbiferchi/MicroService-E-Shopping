
FROM node:20-alpine
WORKDIR /app
RUN npm install -g @angular/cli@17
COPY package.json package-lock.json ./
RUN npm ci
COPY . .
EXPOSE 4200
CMD ["ng", "analytics","off"]
CMD ["ng", "serve", "--host", "0.0.0.0"]