import 'scalajs:main.js'

import { typography, spacing, color, sizing, utility  } from '@vaadin/vaadin-lumo-styles'
import { addLumoGlobalStyles } from "@vaadin/vaadin-lumo-styles/global"

const globalStyles = { 
    typography, 
    spacing,
    color,
    sizing,
    utility
}

Object.keys(globalStyles).forEach(key => {
    addLumoGlobalStyles(key, globalStyles[key])
})