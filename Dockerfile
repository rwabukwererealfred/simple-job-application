FROM node:14.17.0 as builder

WORKDIR /app
COPY . .
RUN npm install
RUN npm run build --prod
EXPOSE 4200

FROM nginx:alpine
COPY --from=builder /app/dist/simpleJobApplicationFrontEnd /usr/share/nginx/html