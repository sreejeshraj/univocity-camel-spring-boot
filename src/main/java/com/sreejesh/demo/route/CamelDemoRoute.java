package com.sreejesh.demo.route;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.dataformat.univocity.UniVocityCsvDataFormat;
import org.apache.camel.dataformat.univocity.UniVocityFixedWidthDataFormat;
import org.apache.camel.spi.DataFormat;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Component
@Data
@EqualsAndHashCode(callSuper = true)
@ConfigurationProperties(prefix = "camel-demo-route")
public class CamelDemoRoute extends RouteBuilder {

	int[] widthOfFields;
		
	@Override
	public void configure() throws Exception {

		// @formatter:off
		
		DataFormat univocityCsvDataFormat = new UniVocityCsvDataFormat()
													.setAsMap(true)
													.setHeaderExtractionEnabled(true);
		DataFormat univocityFixedWidthDataFormat = new UniVocityFixedWidthDataFormat()
													.setAsMap(true)
													.setFieldLengths(widthOfFields);
													//.setHeadersDisabled(false);
		
													
		
		from("file:data/input?delay=60s&noop=true")
		.routeId("inputFileRoute")
		.unmarshal(univocityCsvDataFormat)
		.marshal(univocityFixedWidthDataFormat)
		//.log("*****STEP10-START:bodyType*****\n${body[0].class.name}\n*****STEP10-END*****")
		//.log("*****STEP10-START:body*****\n${body[0]}\n*****STEP10-END*****")
		.log("*****STEP10-START:body*****\n${body}\n*****STEP10-END*****")
		.to("file:data/output?fileName=FixedWidthFile-${date:now:yyyyMMddHHmmssSSS}.txt")
		.log("*****STEP50-Completed!!!*****")
		;
		
		// @formatter:on

	}
	
	





}
