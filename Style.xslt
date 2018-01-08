<?xml version="1.0"?>

<xsl:stylesheet version="1.0"
                xmlns:xsl="http://www.w3.org/1999/XSL/Transform">

    <xsl:template match="/">
        <html bgcolor="#7agf45">
            <body>
                <h2>Parsed different Beers</h2>
                <table border="2">
                    <tr>
                        <th>Name</th>
                        <th>Type</th>
                        <th>Contains Alcohol</th>
                        <th>Manufacturer</th>
                        <th>Ingredients</th>
                        <th>Alcohol</th>
                        <th>Transparency</th>
                        <th>Filtration</th>
                        <th>Nutritional</th>
                        <th>Tare</th>
                    </tr>
                    <xsl:for-each select="Beer/New">
                        <tr>
                            <td><xsl:value-of select="Name"/></td>
                            <td><xsl:value-of select="Type"/></td>
                            <td><xsl:value-of select="Al"/></td>
                            <td><xsl:value-of select="Manufacture"/></td>
                            <td>
                                <ul>
                                    <li>water:<xsl:value-of select="Ingredients/water"/></li>
                                    <li>malt:<xsl:value-of select="Ingredients/malt"/></li>
                                    <li>hops:<xsl:value-of select="Ingredients/hops"/></li>
                                    <li>sugar:<xsl:value-of select="Ingredients/sugar"/></li>
                                    <li>supplements:<xsl:value-of select="Ingredients/supplements"/></li>
                                </ul>
                            </td>
                            <td>
								<xsl:choose>
									<xsl:when test="Al='false' and  Chars/turns">
                                        Non-alcoholic beer must haven't turns!</xsl:when>
									<xsl:otherwise>
										<xsl:value-of select="Chars/turns"/>
									</xsl:otherwise>
								</xsl:choose>
							</td>
                            <td><xsl:value-of select="Chars/transparency"/></td>
                            <td><xsl:value-of select="Chars/filtered"/></td>
                            <td><xsl:value-of select="Chars/nutritional"/></td>
                            <td>
                                <ul>
                                    <xsl:for-each select="Chars/spill/container">
                                        <li><xsl:value-of select="current()"/></li>
                                    </xsl:for-each>
                                </ul>
                            </td>
                        </tr>
                    </xsl:for-each>
                </table>
            </body>
        </html>
    </xsl:template>

</xsl:stylesheet>