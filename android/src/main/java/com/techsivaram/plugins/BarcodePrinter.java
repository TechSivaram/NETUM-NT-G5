package com.techsivaram.plugins;

import android.Manifest;

import com.dothantech.lpapi.LPAPI;
import com.dothantech.lpapi.LPAPI.Factory;
import com.getcapacitor.JSObject;
import com.getcapacitor.NativePlugin;
import com.getcapacitor.Plugin;
import com.getcapacitor.PluginCall;
import com.getcapacitor.PluginMethod;

@NativePlugin(permissions = {
        Manifest.permission.BLUETOOTH,
        Manifest.permission.BLUETOOTH_ADMIN,
        Manifest.permission.BLUETOOTH_PRIVILEGED
})
public class BarcodePrinter extends Plugin {

    private LPAPI api;

    @PluginMethod
    public void getAllPrinters(PluginCall call) {
        api = Factory.createInstance();
        String value = api.getAllPrinters("");
        JSObject ret = new JSObject();
        ret.put("printers", value);
        call.success(ret);
    }

    @PluginMethod
    public void startJob(PluginCall call) {
        double width = call.getDouble("width");
        double height = call.getDouble("height");
        int rotation = call.getInt("rotation");
        api = Factory.createInstance();
        boolean value = api.startJob(width, height, rotation);
        JSObject ret = new JSObject();
        ret.put("status", value);
        call.success(ret);
    }

    @PluginMethod
    public void openPrinter(PluginCall call) {
        String printerName = call.getString("printerName");
        api = Factory.createInstance();
        boolean value = api.openPrinter(printerName);
        JSObject ret = new JSObject();
        ret.put("status", value);
        call.success(ret);
    }

    @PluginMethod
    public void drawBarcode(PluginCall call) {
        String text = call.getString("text");
        double x = call.getDouble("x");
        double y = call.getDouble("y");
        double width = call.getDouble("width");
        double height = call.getDouble("height");
        double textHeight = call.getDouble("textHeight");
        api = Factory.createInstance();
        boolean value = api.draw1DBarcode(text, LPAPI.BarcodeType.AUTO, x, y, width, height, textHeight);
        JSObject ret = new JSObject();
        ret.put("status", value);
        call.success(ret);
    }

    @PluginMethod
    public void drawText(PluginCall call) {
        String text = call.getString("text");
        double x = call.getDouble("x");
        double y = call.getDouble("y");
        double width = call.getDouble("width");
        double height = call.getDouble("height");
        double fontHeight = call.getDouble("fontHeight");
        //fontStyle
        api = Factory.createInstance();
        boolean value = api.drawText(text, x, y, width, height, fontHeight, 0);
        JSObject ret = new JSObject();
        ret.put("status", value);
        call.success(ret);
    }

    @PluginMethod
    public void commitJob(PluginCall call) {
        api = Factory.createInstance();
        boolean value = api.commitJob();
        JSObject ret = new JSObject();
        ret.put("status", value);
        call.success(ret);
    }

    @PluginMethod
    public void printSivaramBarCode(PluginCall call) {
        String printerName = call.getString("printerName");
        String specimenId = call.getString("specimenId");
        String patientName = call.getString("patientName");
        String dateOfBirth = call.getString("dateOfBirth");
        String siteName = call.getString("siteName");
        api = Factory.createInstance();
        boolean value;
        value = api.openPrinter(printerName);
        value = api.startJob(60, 25, 0);
        value = api.draw1DBarcode(specimenId, LPAPI.BarcodeType.AUTO, 15, 3, 40, 8, 3);
        value = api.drawText(patientName, 15, 10, 50, 7, 3);
        value = api.drawText(dateOfBirth, 15, 16, 50, 7, 3);
        value = api.drawText(siteName, 15, 20, 50, 7, 3);
        value = api.commitJob();
        JSObject ret = new JSObject();
        ret.put("status", value);
        call.success(ret);
    }

    @PluginMethod
    public void printText(PluginCall call) {
        String printerName = call.getString("printerName");
        String text = call.getString("text");
        LPAPI api = Factory.createInstance();
        // Connect to the  printer object paired
        api.openPrinter(printerName);

        // Start drawing task, pass in parameters (page width, page height)
        api.startJob(50, 30, 0);

        // Start drawing a page, draw a text string
        api.drawText(text, 4, 5, 40, 30, 4);

        // End the drawing task and submit for printing
        api.commitJob();
    }
}
