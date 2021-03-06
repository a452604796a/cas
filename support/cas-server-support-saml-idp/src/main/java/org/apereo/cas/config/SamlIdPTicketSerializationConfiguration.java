package org.apereo.cas.config;

import org.apereo.cas.configuration.CasConfigurationProperties;
import org.apereo.cas.ticket.artifact.SamlArtifactTicketImpl;
import org.apereo.cas.ticket.query.SamlAttributeQueryTicketImpl;
import org.apereo.cas.ticket.serialization.TicketSerializationExecutionPlan;
import org.apereo.cas.ticket.serialization.TicketSerializationExecutionPlanConfigurer;
import org.apereo.cas.util.serialization.AbstractJacksonBackedStringSerializer;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * This is {@link SamlIdPTicketSerializationConfiguration}.
 *
 * @author Bob Sandiford
 * @since 5.2.0
 */
@Configuration("samlIdpTicketSerializationConfiguration")
@EnableConfigurationProperties(CasConfigurationProperties.class)
public class SamlIdPTicketSerializationConfiguration implements TicketSerializationExecutionPlanConfigurer {

    @Override
    public void configureTicketSerialization(final TicketSerializationExecutionPlan plan) {
        plan.registerTicketSerializer(new AbstractJacksonBackedStringSerializer<SamlArtifactTicketImpl>() {
            private static final long serialVersionUID = -2198623586274810263L;

            @Override
            public Class<SamlArtifactTicketImpl> getTypeToSerialize() {
                return SamlArtifactTicketImpl.class;
            }
        });
        plan.registerTicketSerializer(new AbstractJacksonBackedStringSerializer<SamlAttributeQueryTicketImpl>() {
            private static final long serialVersionUID = -2198623586274810263L;

            @Override
            public Class<SamlAttributeQueryTicketImpl> getTypeToSerialize() {
                return SamlAttributeQueryTicketImpl.class;
            }
        });
    }
}
