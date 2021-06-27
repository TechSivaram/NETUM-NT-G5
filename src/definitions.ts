declare module '@capacitor/core' {
  interface PluginRegistry {
    BarcodePrinter: BarcodePrinterPlugin;
  }
}

export interface BarcodePrinterPlugin {
  getAllPrinters(options: { printerName: string, printers: string }): Promise<{ printers: string }>;
}

export interface BarcodePrinterPlugin {
  openPrinter(options: { printerName: string }): Promise<{ printerName: string }>;
}

export interface BarcodePrinterPlugin {
  startJob(options: { width: string, height: string, rotation: string }): Promise<{ status: boolean }>;
}

export interface BarcodePrinterPlugin {
  drawBarcode(options: { text: string, x: string, y: string, width: string, height: string, textHeight: string }): Promise<{ status: boolean }>;
}

export interface BarcodePrinterPlugin {
  drawText(options: { text: string, x: string, y: string, width: string, height: string, fontHeight: string }): Promise<{ status: boolean }>;
}

export interface BarcodePrinterPlugin {
  commitJob(options: {}): Promise<{ status: boolean }>;
}

export interface printBarCode {
  printCovidBarCode(options: { printerName: string, specimenId: string, patientName: string, dateOfBirth: string, siteName: string, status: boolean }): Promise<{ status: boolean }>;
}

export interface printText {
  printText(options: { printerName: string }): Promise<{ status: boolean }>;
}
