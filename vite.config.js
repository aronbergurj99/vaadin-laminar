import { defineConfig } from "vite"; 
import scalaJSMillPlugin from "vite-plugin-scalajs-mill";

export default defineConfig({
    plugins: [scalaJSMillPlugin({
        moduleNames: "example"
    })],
    server: {
        hmr: true,
        port: 3000
    }
})