const { defineConfig } = require("cypress");

module.exports = defineConfig({
  e2e: {
    setupNodeEvents(on, config) {
      // implement node event listeners here
    },
    baseUrl: 'https://www.advantageonlineshopping.com/#',
    viewportWidth: 1000,
    viewportHeight: 1000
  },
});
