package de.lessvoid.nifty.examples.controls.custom;

import de.lessvoid.nifty.Nifty;
import de.lessvoid.nifty.builder.ControlBuilder;
import de.lessvoid.nifty.builder.ControlDefinitionBuilder;
import de.lessvoid.nifty.builder.EffectBuilder;
import de.lessvoid.nifty.builder.HoverEffectBuilder;
import de.lessvoid.nifty.builder.LabelBuilder;
import de.lessvoid.nifty.builder.PanelBuilder;

public class MenuButtonBuilder {
  private static final String CONTROL_NAME = "menuButtonControl";
  private static final String PARAM_LABEL = "menuButtonLabel";

  public MenuButtonBuilder(final Nifty nifty) {
    new ControlDefinitionBuilder(CONTROL_NAME) {{
      controller(new MenuButtonController());
      panel(new PanelBuilder() {{
        backgroundColor("#55fa");
        width("100px");
        alignCenter();
        valignCenter();
        childLayoutCenter();
        focusable(true);
        visibleToMouse();
        onActiveEffect(new EffectBuilder("border") {{
          parameter("color", "#112f");
        }});
        onHoverEffect(new HoverEffectBuilder("changeMouseCursor") {{
          parameter("id", "hand");
        }});
        onHoverEffect(new HoverEffectBuilder("border") {{
          parameter("color", "#800f");
        }});
        onHoverEffect(new HoverEffectBuilder("gradient") {{
          effectValue("offset", "0%", "color", "#222f");
          effectValue("offset", "100%", "color", "#77ff");
        }});
        onFocusEffect(new EffectBuilder("gradient") {{
          effectValue("offset", "0%", "color", "#222f");
          effectValue("offset", "100%", "color", "#eeff");
        }});
        onCustomEffect(new EffectBuilder("gradient") {{
          parameter("customKey", "selected");
          parameter("timeType", "infinite");
          parameter("neverStopRendering", "true");
          effectValue("offset", "0%", "color", "#222f");
          effectValue("offset", "100%", "color", "#eeff");
        }});
        label(new LabelBuilder() {{
          color("#222f");
          text(controlParameter(PARAM_LABEL));
          alignCenter();
          valignCenter();
          onFocusEffect(new EffectBuilder("textColor") {{
            parameter("color", "#eeef");
          }});
        }});
      }});
    }}.registerControlDefintion(nifty);
  }

  public ControlBuilder getControlBuilder(final String id, final String text) {
    return new ControlBuilder(id, CONTROL_NAME) {{
      parameter(PARAM_LABEL, text);
    }};
  }
}
