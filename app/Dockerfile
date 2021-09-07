FROM node:14
WORKDIR /usr/src/app
COPY package.json .
RUN yarn install
COPY ./src ./src
COPY ./public ./public

RUN ls -la ./public
CMD ["yarn", "start"]