<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.1"
	xmlns:xsl="http://www.w3.org/1999/XSL/Transform" xmlns:fo="http://www.w3.org/1999/XSL/Format"
	xmlns:java="http://xml.apache.org/xslt/java" xmlns:str="http://exslt.org/strings"
	exclude-result-prefixes="fo">
	<xsl:template match="/">
		<fo:root xmlns:fo="http://www.w3.org/1999/XSL/Format">
			<fo:layout-master-set>
				<fo:simple-page-master master-name="simpleA4"
					page-height="21cm" page-width="25cm" margin-top="0.5cm"
					margin-left="0.7cm" margin-right="0.7cm" padding-right="0.3cm">
					<fo:region-body region-name="xsl-region-body"
						margin-top="2.6cm" margin-bottom=".7cm" />
					<fo:region-before region-name="xsl-region-before"
						extent="5in" />
					<fo:region-after region-name="xsl-region-after"
						extent=".5in" />
				</fo:simple-page-master>

			</fo:layout-master-set>
			<fo:page-sequence master-reference="simpleA4">
				<fo:static-content flow-name="xsl-region-before">
					<fo:block>
						<fo:inline-container
							inline-progression-dimension="32.8%">
							<fo:block>
								<xsl:for-each select="report/logo">
									<xsl:variable name="logo">
										<xsl:value-of select="normalize-space(.)" />
									</xsl:variable>
									<fo:external-graphic content-height="scale-to-fit"
										height="0.70in" width="1.90in" content-width="scale-to-fit"
										scaling="non-uniform" src='{$logo}' />
								</xsl:for-each>
							</fo:block>
						</fo:inline-container>
						<fo:inline-container
							inline-progression-dimension="54.1%" margin="5%">
							<fo:block font-size="14pt" font-weight="bold">
								<xsl:for-each select="report/reportTitle">
									<xsl:value-of select="." />
								</xsl:for-each>
							</fo:block>
						</fo:inline-container>
						<fo:inline-container
							inline-progression-dimension="13.1%">
							<fo:block font-size="10pt" font-weight="bold">
								Date:
								<xsl:value-of
									select="java:format(java:java.text.SimpleDateFormat.new('MM/dd/yyyy'), java:java.util.Date.new())" />
							</fo:block>
						</fo:inline-container>
					</fo:block>
					<fo:block>
						<fo:leader leader-length="100%" leader-pattern="rule"
							rule-style="solid" rule-thickness="1px" />
					</fo:block>
				</fo:static-content>
				<fo:static-content flow-name="xsl-region-after">
					<fo:block>
						<fo:leader leader-length="100%" leader-pattern="rule"
							rule-style="solid" rule-thickness="0.9px" />
					</fo:block>
					<fo:block>
						<fo:inline-container
							inline-progression-dimension="97.0%">

							<fo:block font-size="10pt" font-weight="bold">
								www.fhlbny.com
							</fo:block>
						</fo:inline-container>
						<fo:inline-container
							inline-progression-dimension="3.0%">
							<fo:block font-size="10pt" font-weight="bold"
								text-align="start">
								<fo:page-number />
							</fo:block>
						</fo:inline-container>
					</fo:block>
				</fo:static-content>
				<fo:flow flow-name="xsl-region-body">
					<xsl:choose>
						<xsl:when test="count(report/data/*)=0">
							<fo:block font-size="16pt" text-align="center" color="#ff3333"
								padding-top="4cm">
								...No Data found...
							</fo:block>
						</xsl:when>
						<xsl:otherwise>
							<fo:block font-size="8pt">
								<fo:table table-layout="fixed" width="100%"
									border-width="2px" border-spacing="0pt 2pt">
									<fo:table-header font-size="10pt"
										margin-bottom="2cm">
										<fo:table-cell padding-top="0.3cm" width="5cm"
											padding-bottom="0.3cm" background-color="#80bbe4">
											<fo:block font-weight="bold" text-align="start"
												margin-left=".3cm">
												Code
											</fo:block>
										</fo:table-cell>
										<fo:table-cell padding-top="0.3cm" 
											padding-bottom="0.3cm" background-color="#80bbe4">
											<fo:block font-weight="bold" text-align="start"
												margin-left=".1cm">
												Description
											</fo:block>
										</fo:table-cell>
										<fo:table-cell padding-top="0.3cm" width="4cm"
											padding-bottom="0.3cm" background-color="#80bbe4">
											<fo:block font-weight="bold" text-align="start"
												margin-left=".3cm">
												Ind Fee Calc Flag
											</fo:block>
										</fo:table-cell>
										<fo:table-cell padding-top="0.3cm" width="4cm"
											padding-bottom="0.3cm" background-color="#80bbe4">
											<fo:block font-weight="bold" text-align="start"
												margin-left=".3cm">
												Act Fee Calc Flag
											</fo:block>
										</fo:table-cell>
										<fo:table-cell padding-top="0.3cm" width="4cm"
											padding-bottom="0.3cm" background-color="#80bbe4">
											<fo:block font-weight="bold" text-align="start"
												margin-left=".3cm">
												Act Repl Rate Flag
											</fo:block>
										</fo:table-cell>
									</fo:table-header>
									<fo:table-body>
										<xsl:for-each select="report/data/*">
											<xsl:variable name="bgclr">
												<xsl:choose>
													<xsl:when test="position() mod 2">
														#e2edf7
													</xsl:when>
													<xsl:otherwise>
														#FFFFFF
													</xsl:otherwise>
												</xsl:choose>
											</xsl:variable>
											<fo:table-row height="1cm" background-color="{$bgclr}">
												<fo:table-cell display-align="center" 
													text-align="start">
													<fo:block font-weight="normal" margin-left=".3cm">
														<xsl:value-of select="code/." />
													</fo:block>
												</fo:table-cell>
												<fo:table-cell display-align="center"
													text-align="start">
													<fo:block font-weight="normal" margin-left=".1cm">
														<xsl:value-of select="desc/." />
													</fo:block>
												</fo:table-cell>
												<fo:table-cell display-align="center"
													text-align="start">
													<fo:block font-weight="normal" margin-left=".3cm">
														<xsl:value-of select="indFeeCalcFlag/." />
													</fo:block>
												</fo:table-cell>
												<fo:table-cell display-align="center"
													text-align="start">
													<fo:block font-weight="normal" margin-left=".3cm">
														<xsl:value-of select="actFeeCalcFlag/." />
													</fo:block>
												</fo:table-cell>
												<fo:table-cell display-align="center"
													text-align="start">
													<fo:block font-weight="normal" margin-left=".3cm">
														<xsl:value-of select="actReplRateFlag/." />
													</fo:block>
												</fo:table-cell>
											</fo:table-row>
										</xsl:for-each>
									</fo:table-body>
								</fo:table>
							</fo:block>
						</xsl:otherwise>
					</xsl:choose>
				</fo:flow>
			</fo:page-sequence>
		</fo:root>
	</xsl:template>
</xsl:stylesheet>