/// <reference types = "cypress"/> 
import PaymentDone from '../Pages/P14_PaymentDonePage';

class PaymentPage {
    nameOnCardFieldLocator = '[data-qa = "name-on-card"]';
    cardNumberFieldLocator = '[data-qa = "card-number"]';
    cvcFieldLocator = '[data-qa = "cvc"]';
    expirationMonthFieldLocator = '[data-qa = "expiry-month"]';
    expirationYearFieldLocator = '[data-qa = "expiry-year"]';
    payAndConfirmOrderButtonLocator = '[data-qa = "pay-button"]';

    fillPaymentInfo(nameOnCard, cardNumber, cvc, expirationMonth, expirationYear) {
        cy.get(this.nameOnCardFieldLocator).type(nameOnCard);
        cy.get(this.cardNumberFieldLocator).type(cardNumber);
        cy.get(this.cvcFieldLocator).type(cvc);
        cy.get(this.expirationMonthFieldLocator).type(expirationMonth);
        cy.get(this.expirationYearFieldLocator).type(expirationYear);
        return this;
    }

    clickOnPayAndConfirmOrderButton() {
        cy.get(this.payAndConfirmOrderButtonLocator).click();
        return PaymentDone;
    }
}

export default new PaymentPage();