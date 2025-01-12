import "./styles.css"

import { typography, spacing, color, utility, badge,} from '@vaadin/vaadin-lumo-styles'
import { addLumoGlobalStyles } from "@vaadin/vaadin-lumo-styles/global"

import 'scalajs:main.js'


const globalStyles = { 
    typography, 
    color,
    spacing,
    badge,
    utility,
}

Object.keys(globalStyles).forEach(key => {
    addLumoGlobalStyles(key, globalStyles[key].cssText)
})
