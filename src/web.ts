import { WebPlugin } from '@capacitor/core';
import { BarcodePrinterPlugin } from './definitions';

export class BarcodePrinterWeb extends WebPlugin implements BarcodePrinterPlugin {
  constructor() {
    super({
      name: 'BarcodePrinter',
      platforms: ['web'],
    });
  }
  async openPrinter(options: { printerName: string }): Promise<{ printerName: string }> {
    return options;
  }
  async startJob(options: { width: string, height: string, rotation: string, status: boolean }): Promise<{ status: boolean; }> {
    return options;
  }
  async drawBarcode(options: { text: string, x: string, y: string, width: string, height: string, textHeight: string, status: boolean }): Promise<{ status: boolean; }> {
    return options;
  }
  async drawText(options: { text: string, x: string, y: string, width: string, height: string, fontHeight: string, status: boolean }): Promise<{ status: boolean; }> {
    return options;
  }
  async commitJob(options: { status: boolean }): Promise<{ status: boolean }> {
    return options;
  }
  async getAllPrinters(options: { printers: string }): Promise<{ printers: string }> {
    return options;
  }
  async printCovidBarCode(options: { printerName: string, specimenId: string, patientName: string, dateOfBirth: string, siteName: string, status: boolean }): Promise<{ status: boolean }> {
    return options;
  }
  async printText(options: { printerName: string, status: boolean }): Promise<{ status: boolean }> {
    return options;
  }
}

const BarcodePrinter = new BarcodePrinterWeb();

export { BarcodePrinter };

import { registerWebPlugin } from '@capacitor/core';
registerWebPlugin(BarcodePrinter);
