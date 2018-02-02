package ltd.zndo.oss.admin.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/components")
public class ComponentsFormsController {
	
	@RequestMapping("/forms/controls/base.html")
	public String base() {
		return "/components/forms/controls/base";
	}
	
	@RequestMapping("/forms/controls/checkbox-radio.html")
	public String checkboxRadio() {
		return "/components/forms/controls/checkbox-radio";
	}
	
	@RequestMapping("/forms/controls/input-group.html")
	public String inputGroup() {
		return "/components/forms/controls/input-group";
	}
	
	@RequestMapping("/forms/controls/option.html")
	public String option() {
		return "/components/forms/controls/option";
	}
	
	@RequestMapping("/forms/controls/switch.html")
	public String switchP() {
		return "/components/forms/controls/switch";
	}
	
	@RequestMapping("/forms/layouts/action-bars.html")
	public String actionBars() {
		return "/components/forms/layouts/action-bars";
	}
	
	@RequestMapping("/forms/layouts/default-forms.html")
	public String defaultForms() {
		return "/components/forms/layouts/default-forms";
	}
	
	@RequestMapping("/forms/layouts/multi-column-forms.html")
	public String multiColumnForms() {
		return "/components/forms/layouts/multi-column-forms";
	}
	
	@RequestMapping("/forms/validation/form-controls.html")
	public String formControls() {
		return "/components/forms/validation/form-controls";
	}
	
	@RequestMapping("/forms/validation/form-widgets.html")
	public String formWidgets() {
		return "/components/forms/validation/form-widgets";
	}
	
	@RequestMapping("/forms/validation/states.html")
	public String states() {
		return "/components/forms/validation/states";
	}
	
	@RequestMapping("/forms/widgets/autosize.html")
	public String autosize() {
		return "/components/forms/widgets/autosize";
	}
	
	@RequestMapping("/forms/widgets/bootstrap-datepicker.html")
	public String bootstrapDatepicker() {
		return "/components/forms/widgets/bootstrap-datepicker";
	}
	
	@RequestMapping("/forms/widgets/bootstrap-daterangepicker.html")
	public String bootstrapDaterangepicker() {
		return "/components/forms/widgets/bootstrap-daterangepicker";
	}
	
	@RequestMapping("/forms/widgets/bootstrap-datetimepicker.html")
	public String bootstrapDatetimepicker() {
		return "/components/forms/widgets/bootstrap-datetimepicker";
	}
	
	@RequestMapping("/forms/widgets/bootstrap-markdown.html")
	public String bootstrapMarkdown() {
		return "/components/forms/widgets/bootstrap-markdown";
	}
	
	@RequestMapping("/forms/widgets/bootstrap-maxlength.html")
	public String bootstrapMaxlength() {
		return "/components/forms/widgets/bootstrap-maxlength";
	}
	
	@RequestMapping("/forms/widgets/bootstrap-multipleselectsplitter.html")
	public String bootstrapMultipleselectsplitter() {
		return "/components/forms/widgets/bootstrap-multipleselectsplitter";
	}
	
	@RequestMapping("/forms/widgets/bootstrap-select.html")
	public String bootstrapSelect() {
		return "/components/forms/widgets/bootstrap-select";
	}
	
	@RequestMapping("/forms/widgets/bootstrap-switch.html")
	public String bootstrapSwitch() {
		return "/components/forms/widgets/bootstrap-switch";
	}
	
	@RequestMapping("/forms/widgets/bootstrap-timepicker.html")
	public String bootstrapTimepicker() {
		return "/components/forms/widgets/bootstrap-timepicker";
	}
	
	@RequestMapping("/forms/widgets/bootstrap-touchspin.html")
	public String bootstrapTouchspin() {
		return "/components/forms/widgets/bootstrap-touchspin";
	}
	
	@RequestMapping("/forms/widgets/clipboard.html")
	public String clipboard() {
		return "/components/forms/widgets/clipboard";
	}
	
	@RequestMapping("/forms/widgets/dropzone.html")
	public String dropzone() {
		return "/components/forms/widgets/dropzone";
	}
	
	@RequestMapping("/forms/widgets/form-repeater.html")
	public String formRepeater() {
		return "/components/forms/widgets/form-repeater";
	}
	
	@RequestMapping("/forms/widgets/input-mask.html")
	public String inputMask() {
		return "/components/forms/widgets/input-mask";
	}
	
	@RequestMapping("/forms/widgets/ion-range-slider.html")
	public String ionRangeSlider() {
		return "/components/forms/widgets/ion-range-slider";
	}
	
	@RequestMapping("/forms/widgets/nouislider.html")
	public String nouislider() {
		return "/components/forms/widgets/nouislider";
	}
	
	@RequestMapping("/forms/widgets/recaptcha.html")
	public String recaptcha() {
		return "/components/forms/widgets/recaptcha";
	}
	
	@RequestMapping("/forms/widgets/select2.html")
	public String select2() {
		return "/components/forms/widgets/select2";
	}
	
	@RequestMapping("/forms/widgets/summernote.html")
	public String summernote() {
		return "/components/forms/widgets/summernote";
	}
	
	@RequestMapping("/forms/widgets/typeahead.html")
	public String typeahead() {
		return "/components/forms/widgets/typeahead";
	}
	
	@RequestMapping("/forms/wizard/wizard-1.html")
	public String wizard1() {
		return "/components/forms/wizard/wizard-1";
	}
	
	@RequestMapping("/forms/wizard/wizard-2.html")
	public String wizard2() {
		return "/components/forms/wizard/wizard-2";
	}
	
	@RequestMapping("/forms/wizard/wizard-3.html")
	public String wizard3() {
		return "/components/forms/wizard/wizard-3";
	}
	
	@RequestMapping("/forms/wizard/wizard-4.html")
	public String wizard4() {
		return "/components/forms/wizard/wizard-4";
	}
	
	@RequestMapping("/forms/wizard/wizard-5.html")
	public String wizard5() {
		return "/components/forms/wizard/wizard-5";
	}

}
