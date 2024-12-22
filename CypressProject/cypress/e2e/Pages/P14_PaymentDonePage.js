/// <reference types = "cypress"/> 

class PaymentDonePage {
    orderPlacedTextLocator = 'Order Placed!';
    downloadInvoiceButtonLocator = 'Download Invoice';

    verifyVisibilityOfOrderPlacedText() {
        cy.contains(this.orderPlacedTextLocator).should('be.visible');
    }

    clickOnDownloadInvoice() {
        cy.contains(this.downloadInvoiceButtonLocator).click();
    }
}

export default new PaymentDonePage();