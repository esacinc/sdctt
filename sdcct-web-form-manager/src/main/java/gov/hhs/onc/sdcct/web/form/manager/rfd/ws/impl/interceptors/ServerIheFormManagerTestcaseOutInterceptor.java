package gov.hhs.onc.sdcct.web.form.manager.rfd.ws.impl.interceptors;

import gov.hhs.onc.sdcct.testcases.SdcctTestcasePropertyNames;
import gov.hhs.onc.sdcct.testcases.ihe.IheFormManagerTestcase;
import gov.hhs.onc.sdcct.testcases.results.ihe.IheFormManagerTestcaseResult;
import gov.hhs.onc.sdcct.testcases.rfd.impl.interceptors.AbstractIheTestcaseInterceptor;
import gov.hhs.onc.sdcct.testcases.utils.SdcctTestcaseUtils;
import org.apache.cxf.binding.soap.SoapMessage;
import org.apache.cxf.message.Message;
import org.apache.cxf.phase.Phase;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component("interceptorServerIheFormManagerTestcaseOut")
public class ServerIheFormManagerTestcaseOutInterceptor extends AbstractIheTestcaseInterceptor<IheFormManagerTestcase> {
    private final static Logger LOGGER = LoggerFactory.getLogger(ServerIheFormManagerTestcaseOutInterceptor.class);

    public ServerIheFormManagerTestcaseOutInterceptor() {
        super(Phase.MARSHAL);
    }

    @Override
    protected void handleMessageInternal(SoapMessage message) throws Exception {
        LOGGER.info(String.format("Handling message in interceptor (class=%s).", this.getClass().getName()));

        Message inMsg = message.getExchange().getInMessage();
        Object resultPropValue = inMsg.getContextualProperty(SdcctTestcasePropertyNames.IHE_FORM_MANAGER_TESTCASE_RESULT);

        if (resultPropValue != null) {
            IheFormManagerTestcaseResult result = SdcctTestcaseUtils.addWsResponseEvent(inMsg, SdcctTestcasePropertyNames.IHE_FORM_MANAGER_TESTCASE_RESULT,
                IheFormManagerTestcaseResult.class, message.getExchange().getOutMessage());

            // TODO: implement
        }
    }
}
