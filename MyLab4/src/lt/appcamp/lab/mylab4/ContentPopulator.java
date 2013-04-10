
package lt.appcamp.lab.mylab4;

import java.util.ArrayList;

import android.content.ContentValues;

/**
 * Class which add content to MyDatabase
 * 
 * @author Tadas Valaitis
 *
 */
public class ContentPopulator {

	/** MyDatabase **/
    private MyDatabase database;
    
    /** ContentValues array **/
    private ArrayList<ContentValues> peopleValues = new ArrayList<ContentValues>();

    ContentPopulator(MyDatabase database) {
        this.database = database;
    }

    /**
     * put People to database
     * 
     * insert + transactions are used
     */
    public void populatePeoples() {

        putPeople(1,"Käthe Gold","stage actress");
        putPeople(1,"Liane Haid","first Austrian movie star.");
        putPeople(1,"Hans Moser","comedy actor");
        putPeople(1,"Arnold Schwarzenegger","bodybuilder");
        putPeople(1,"Hedy Lamarr","actress; also co-inventor of spread spectrum radio technology; became U.S. citizen");
        putPeople(1,"Christiane Hörbiger","actress a star");
        putPeople(1,"Senta Berger","actress");
        putPeople(1,"Birgit Minichmayr","actress");
        putPeople(1,"Romy Schneider","actress");
        putPeople(1,"Erich von Stroheim","actor and film director");
        putPeople(1,"Leon Askin","actor");
        putPeople(1,"Helmut Berger","actor");
        putPeople(1,"Klaus Maria Brandauer","actor");
        putPeople(1,"Attila Hörbiger","actor");
        putPeople(1,"Paul Hörbiger","actor");
        putPeople(1,"Maximilian Schell","actor");
        putPeople(1,"Christoph Waltz","actor");
        putPeople(1,"Heinz Weixelbraun","actor");
        putPeople(1,"Oskar Werner","actor");
        putPeople(2,"Zhang Heng-Astronomer","mathematician poet official and inventor.");
        putPeople(2,"Zu Chongzhi-Noted","for calculating Pi to seven places");
        putPeople(3,"Marija Omaljev","Grbić");
        putPeople(3,"Ivan Pavletić","actor writer director");
        putPeople(4,"Tõnu Tõniste (born 1967)","yachtsman");
        putPeople(4,"Toomas Tõniste (born 1967)","yachtsman");
        putPeople(4,"Aleksander Aberg (1881–1920)","wrestler");
        putPeople(4,"Georg Hackenschmidt (1878–1968)","wrestler");
        putPeople(4,"Osvald Käpp (1905–1995)","wrestler");
        putPeople(4,"Martin Klein (1884–1947)","wrestler");
        putPeople(4,"Anton Koolmann (1899–1953)","wrestler");
        putPeople(4,"Johannes Kotkas (1915–1998)","wrestler");
        putPeople(4,"Albert Kusnets (1902–1942)","wrestler");
        putPeople(4,"Georg Lurich (1876–1920)","wrestler");
        putPeople(4,"August Neo (1908–1982)","wrestler");
        putPeople(4,"Kristjan Palusalu (1908–1987)","wrestler");
        putPeople(4,"Eduard Pütsep (1898–1960)","wrestler");
        putPeople(4,"Roman Steinberg (1900–1928)","wrestler");
        putPeople(4,"Voldemar Väli (1903–1997)","wrestler");
        putPeople(4,"Tarmo Mitt (born 1977)","World Strong Man");
        putPeople(4,"Jaan Kikkas (1892–1944)","weightlifter");
        putPeople(4,"Arnold Luhaäär (1905–1965)","weightlifter");
        putPeople(4,"Alfred Neuland (1895–1966)","weightlifter");
        putPeople(4,"Alfred Schmidt (1898–1972)","weightlifter");
        putPeople(4,"Jaan Talts (born 1944)","weightlifter");
        putPeople(4,"Maret Ani (born 1982)","tennis player");
        putPeople(4,"Kaia Kanepi (born 1985)","tennis player");
        putPeople(4,"Anett Kontaveit (born 1995)","tennis player");
        putPeople(4,"Sven Salumaa (born 1966)","tennis player");
        putPeople(4,"Ants Antson (born 1938)","speedskater");
        putPeople(4,"Jaak Mae (born 1972)","skier");
        putPeople(4,"Kristina Šmigun-Vähi (born 1977)","skier");
        putPeople(4,"Andrus Veerpalu (born 1971)","skier");
        putPeople(4,"Jüri Jaanson (born 1965)","rower");
        putPeople(4,"Markko Märtin (born 1975)","rally driver");
        putPeople(4,"Marko Asmer (born 1984)","racing driver");
        putPeople(4,"Toomas Edur (born 1954","NHL hockey player");
        putPeople(4,"Tanel Leok (born 1985)","motocross rider");
        putPeople(4,"Jane Salumäe (born 1968)","marathon runner");
        putPeople(4,"Jüri Lossmann (1891–1984)","long distance runner");
        putPeople(4,"Aleksei Budõlin (born 1976)","judoka");
        putPeople(4,"Indrek Pertelson (born 1971)","judoka");
        putPeople(4,"Harald Tammer (1899–1942)","journalist");
        putPeople(4,"Moonika Aava (born 1979)","javelin thrower");
        putPeople(4,"Andrus Värnik (born 1977)","javelin thrower");
        putPeople(4,"Siim Liivik (born 1988)","ice hockey player");
        putPeople(4,"Toivo Suursoo (born 1975)","ice hockey player");
        putPeople(4,"Jüri Tarmak (born 1946)","high jumper");
        putPeople(4,"Joel Lindpere (born 1981)","footballer for New York Red Bulls and the Estonian National Team");
        putPeople(4,"Eduard Ellman-Eelma (1902–1943)","football player");
        putPeople(4,"Marko Kristal (born 1973)","football player");
        putPeople(4,"Andres Oper (born 1977)","football player");
        putPeople(4,"Mart Poom (born 1972)","football player");
        putPeople(4,"Gerd Kanter (born 1979)","discus thrower");
        putPeople(4,"Aleksander Tammert (born 1973)","discus thrower");
        putPeople(4,"Aleksander Klumberg (1899–1958)","decathlete");
        putPeople(4,"Heino Lipp (1922–2006)","decathlete");
        putPeople(4,"Erki Nool (born 1970)","decathlete");
        putPeople(4,"Kristjan Rahnu (born 1979)","decathlete");
        putPeople(4,"Lauri Aus (1970–2003)","cyclist");
        putPeople(4,"Jaan Kirsipuu (born 1969)","cyclist");
        putPeople(4,"Erika Salumäe (born 1962)","cyclist");
        putPeople(4,"Ortvin Sarapu (1924–1999)","chess player (New Zealand)");
        putPeople(4,"Friedrich Amelung (1842–1909)","chess player");
        putPeople(4,"Jaan Ehlvest (born 1962)","chess player");
        putPeople(4,"Gunnar Friedemann (1909–1943)","chess player");
        putPeople(4,"Paul Keres (1916–1975)","chess player");
        putPeople(4,"Lionel Kieseritzky (1806–1853)","chess player");
        putPeople(4,"Leho Laurine (1904–1998)","chess player");
        putPeople(4,"Iivo Nei (born 1931)","chess player");
        putPeople(4,"Tõnu Õim (born 1941)","chess player");
        putPeople(4,"Lembit Oll (1966–1999)","chess player");
        putPeople(4,"Ilmar Raud (1913–1941)","chess player");
        putPeople(4,"Salme Rootare (1913–1987)","chess player");
        putPeople(4,"Vidrik Rootare (c. 1900–1985)","chess player");
        putPeople(4,"Paul Felix Schmidt (1916–1984)","chess player");
        putPeople(4,"Johannes Türn (1898–1993)","chess player");
        putPeople(4,"Meelis Kanep (born 1983)","chess grandmaster");
        putPeople(4,"Nikolai Stepulov (1913–1968)","boxer");
        putPeople(4,"Michael Roos (Mihkel Roos","born 1982)");
        putPeople(4,"Tiit Sokk (born 1964)","basketball player (1988 Olympic Gold Medalist for USSR)");
        putPeople(4,"Martin Müürsepp (born 1974)","basketball player");
        putPeople(4,"Michael Roos (born 1982)","American football player");
        putPeople(5,"Kain Tapper","sculptor (1930–2004)");
        putPeople(5,"Reidar Särestöniemi","painter (1925–1981)");
        putPeople(5,"Eija-Liisa Ahtila – photographer","video artist (born 1959)");
        putPeople(5,"Tove Jansson painter","illustrator");
        putPeople(6,"Fabrice Benichou","world champion super bantamweight boxer");
        putPeople(6,"Georges Carpentier","world champion boxer");
        putPeople(6,"Marcel Cerdan","world champion boxer");
        putPeople(6,"Eugène Criqui","world champion boxer");
        putPeople(6,"Marcel Thil","world champion boxer");
        putPeople(6,"Christophe Tiozzo","world champion boxer");
        putPeople(6,"Fabrice Tiozzo","world champion boxer");
        putPeople(6,"Robert Cohen","world champion bantamweight boxer");
        putPeople(6,"Serge Blanco","Venezuela born French citizen");
        putPeople(6,"Marion Bartoli","tennis player");
        putPeople(6,"Stéphanie Cohen-Aloro","tennis player");
        putPeople(6,"Pierre Darmon","tennis player");
        putPeople(6,"Suzanne Lenglen","tennis player");
        putPeople(6,"Amélie Mauresmo","tennis player");
        putPeople(6,"Yannick Noah","tennis player");
        putPeople(6,"Marlène Harnois (born 1986)","taekwondo practitioner");
        putPeople(6,"Laure Manaudou","swimmer");
        putPeople(6,"Jeremy Flores","surfer");
        putPeople(6,"Myriam Fox-Jerusalmi","slalom canoer");
        putPeople(6,"Jean-Claude Killy","skier");
        putPeople(6,"Carole Montillet","skier");
        putPeople(6,"Patrick Vieira","Senegal born French citizen");
        putPeople(6,"Jacques Fouroux","rugby union player and coach");
        putPeople(6,"Sébastien Loeb","rally driver and 5-time champion");
        putPeople(6,"Émile Delahaye","race car pioneer");
        putPeople(6,"Camille du Gast","race car driver");
        putPeople(6,"Jean-Pierre Wimille","race car driver");
        putPeople(6,"André the Giant","professional wrestler");
        putPeople(6,"Hellé Nice","pioneer female race car driver");
        putPeople(6,"Sarah Abitbol","pairs figure skater (with S. Bernadis); World Figure Skating Championship bronze[1]");
        putPeople(6,"Stéphane Bernadis","pairs figure skater (with S. Abitbol)");
        putPeople(6,"Alain Bernard","Olympic swimmer");
        putPeople(6,"Jean Bloch","Olympic silver football player");
        putPeople(6,"Micheline Ostermeyer","Olympic champion in discus and shot put");
        putPeople(6,"Joakim Noah","NBA basketball player (Chicago Bulls)");
        putPeople(6,"Olivier Jacque","motorcycle rider");
        putPeople(6,"Richard Virenque","Morocco born French citizen");
        putPeople(6,"Andre Ethier","Major League Baseball outfielder for the Los Angeles Dodgers");
        putPeople(6,"David Douillet","judo");
        putPeople(6,"Jean Cruguet","jockey of Seattle Slew");
        putPeople(6,"Georges Stern","jockey");
        putPeople(6,"François Rozenthal","ice hockey player");
        putPeople(6,"Maurice Rozenthal","ice hockey player");
        putPeople(6,"Pascal Lavanchy","ice dancer (with S. Moniotte)");
        putPeople(6,"Sophie Moniotte","ice dancer (with P. Lavanchy)");
        putPeople(6,"Gwendal Peizerat","ice dancer");
        putPeople(6,"André Fabre","horse trainer");
        putPeople(6,"Cristobal Huet","hockey player");
        putPeople(6,"Marcel Desailly","Ghana born French citizen");
        putPeople(6,"Alain Prost","Formula One driver and 4-time champion");
        putPeople(6,"Max Jean","Formula One driver");
        putPeople(6,"Claude Makélélé","football player: PSG");
        putPeople(6,"Patrice Evra","football player: Monaco + Manchester United");
        putPeople(6,"Fabien Barthez","football player");
        putPeople(6,"Eric Cantona","football player");
        putPeople(6,"Abou Diaby","football player");
        putPeople(6,"Just Fontaine","football player");
        putPeople(6,"Yoann Gourcuff","football player");
        putPeople(6,"Rudy Haddad","football player");
        putPeople(6,"Thierry Henry","football player");
        putPeople(6,"Raymond Kopa","football player");
        putPeople(6,"Bixente Lizarazu","football player");
        putPeople(6,"Michel Platini","football player");
        putPeople(6,"David Trezeguet","football player");
        putPeople(6,"Zinedine Zidane","football (soccer) Player");
        putPeople(6,"Claude Netter","foil fencer");
        putPeople(6,"Surya Bonaly","figure skater");
        putPeople(6,"Alain Calmat","figure skater");
        putPeople(6,"Philippe Candeloro","figure skater");
        putPeople(6,"Brian Joubert","figure skater");
        putPeople(6,"Éric Millot","figure skater");
        putPeople(6,"Lucien Gaudin","fencer");
        putPeople(6,"Julien Pillet","fencer");
        putPeople(6,"Jacques Anquetil","cyclist");
        putPeople(6,"Louison Bobet","cyclist");
        putPeople(6,"Eugène Christophe","cyclist");
        putPeople(6,"Laurent Fignon","cyclist");
        putPeople(6,"Bernard Hinault","cyclist");
        putPeople(6,"Constant Huret","cyclist");
        putPeople(6,"Laurent Jalabert","cyclist");
        putPeople(6,"Jeannie Longo","cyclist");
        putPeople(6,"André Mahé","cyclist");
        putPeople(6,"Jose Meiffret","cyclist");
        putPeople(6,"Roger Walkowiak","cyclist");
        putPeople(6,"Stéphane Peterhansel","car and motor racer");
        putPeople(6,"Mary Pierce","Canadian-born French citizen");
        putPeople(6,"Serge Betsen","Cameroon born French citizen");
        putPeople(6,"Stéphane Haccoun","boxer");
        putPeople(6,"Rene Jacquot","boxer");
        putPeople(6,"Tony Parker","Belgian born French citizen");
        putPeople(6,"Pierre Galle","basketball player and coach");
        putPeople(6,"Tariq Abdul-Wahad","basketball player (born Olivier Saint-Jean)");
        putPeople(6,"Richard Dacoury","basketball player");
        putPeople(6,"Boris Diaw","basketball player");
        putPeople(6,"Antoine Rigaudeau","basketball player");
        putPeople(6,"Alain Mimoun","athlete");
        putPeople(6,"Marie-José Pérec","athlete");
        putPeople(6,"Luc Alphand","Alpine skier");
        putPeople(6,"Andrée Brunet & Pierre Brunet","1928 & 1932 Olympic skating Gold Medalists");
        putPeople(7,"Kálmán Kandó","pioneer in the development of railway electric traction");
        putPeople(7,"Ottó Bláthy","inventor of the voltage regulator");
        putPeople(7,"Tivadar Puskás","inventor of the telephone exchange");
        putPeople(7,"Dénes Gábor","inventor of the holography (1947)");
        putPeople(7,"Csaba Horváth","inventor of the high-performance liquid chromatograph");
        putPeople(7,"Donát Bánki","inventor of the cross-flow turbine");
        putPeople(7,"János Csonka","inventor of the carburetor");
        putPeople(7,"Ferenc Anisits","inventor of the BMW diesel engine (1983)");
        putPeople(7,"Joseph Petzval","inventor of the binocular (1840)");
        putPeople(7,"László Bíró","inventor of the ballpoint pen (1931)");
        putPeople(7,"János Irinyi","inventor of noiseless match (1836)");
        putPeople(7,"Oszkár Asbóth","inventor of helicopter (1928)");
        putPeople(7,"Kálmán Tihanyi","inventor of cathode ray tubes");
        putPeople(7,"Joseph Pulitzer","creator of the Pulitzer Prize (1917)");
        putPeople(7,"József Galamb","creator of the Ford Model T (1908)");
        putPeople(7,"József Dobos","creator of the Dobos cake (1884)");
        putPeople(7,"John von Neumann","computer pioneer (1944)");
        putPeople(7,"Ányos Jedlik","co-inventor of dynamo (1861) and soda water (1826)");
        putPeople(7,"Károly Zipernowsky","co-inventor (with Ottó Bláthy and Miksa Déri) of the transformer");
        putPeople(7,"Miksa Déri","co-inventor (with Ottó Bláthy and Károly Zipernowsky) of the transformer");
        putPeople(8,"Eduardo De Filippo (1900–1984)","playwright and actor. In his scores of plays he combined pathos and farce");
        putPeople(8,"Vittorio Gassman (1922–2000)","film and theatre actor and director");
        putPeople(8,"Ugo Tognazzi (1922–1990)","film and theatre actor");
        putPeople(8,"Totò (1898–1967)","actor. Likened by international film critics to the American film comic Buster Keaton[1]");
        putPeople(8,"Gian Maria Volontè (1933–1994)","actor. He is perhaps best known outside of Italy for his roles in A Fistful of Dollars (1964) and For a Few Dollars More (1965)");
        putPeople(8,"Amedeo Nazzari (1907–1979)","actor. He had a long and distinguished movie career");
        putPeople(8,"Alberto Sordi (1920–2003)","actor. Depicted the vices");
        putPeople(8,"Elio Germano (born 1980)","actor who won the Best Actor Award at the Cannes Film Festival in 2010");
        putPeople(8,"Marcello Mastroianni (1924–1996)","actor who became the preeminent leading man in Italian cinema during the 1960s. He acted in more than 100 movies");
        putPeople(8,"Gino Cervi (1901–1974)","actor and manager best known outside of Italy for his film portrayal of a small-town Communist mayor in the Don Camillo films");
        putPeople(8,"Giancarlo Giannini (born 1942)","actor and dubber");
        putPeople(8,"Massimo Troisi (1953–1994)","actor and director. Internationally");
        putPeople(8,"Terence Hill (born 1939)","actor");
        putPeople(8,"Nino Manfredi (1921–2004)","actor");
        putPeople(8,"Rudolph Valentino (1895–1926)","actor");
        putPeople(8,"Carlo Verdone (born 1950)","actor");
        putPeople(9,"Kārlis Goppers (1876–1941) – general","founder of Latvian Boy Scouts");
        putPeople(10,"Antanas Škėma (1911–1961)","writer in exile");
        putPeople(10,"Vincas Kudirka (1858–1899)","writer and poet");
        putPeople(10,"Vincas Mykolaitis-Putinas (1893–1967)","writer and poet");
        putPeople(10,"Vincas Krėvė-Mickevičius (1882–1954)","writer and playwright");
        putPeople(10,"Romualdas Granauskas (1939–)","writer about the identity crisis during the Soviet times");
        putPeople(10,"Juozas Glinskis (1933–)","writer");
        putPeople(10,"Balys Sruoga (1896–1947)","writer");
        putPeople(10,"Antanas Vienuolis (real name Žukauskas 1882–1957)","writer");
        putPeople(10,"Rolandas Kazlas (1969–)","well-known comedy actor");
        putPeople(10,"Anthony Kiedis (1962-)","vocalist and member of Red Hot Chili Peppers group ;");
        putPeople(10,"Regimantas Adomaitis (1937–)","theatre and film actor");
        putPeople(10,"Adolfas Večerskis (1949–)","theatre and film actor");
        putPeople(10,"Juozas Miltinis (1907–1994)","theater director from Panevėžys");
        putPeople(10,"Eimuntas Nekrošius (1952–)","theater director");
        putPeople(10,"Jonas Vaitkus (1944–)","theater director");
        putPeople(10,"Jurga Ivanauskaitė (1961–2007)","the best known modern female writer");
        putPeople(10,"Alanas Chošnau (1974–)","singer");
        putPeople(10,"Marijonas Mikutavičius (1971–)","singer");
        putPeople(10,"Petras Cvirka (1909–1947)","short story writer and active supporter of communism");
        putPeople(10,"Andrius Mamontovas (1967–)","rock singer");
        putPeople(10,"Czesław Miłosz (1911–2004)","recipient of the 1980 Nobel Prize for Literature");
        putPeople(10,"Antanas Baranauskas (1835–1902)","priest and poet");
        putPeople(10,"Antanas Strazdas (1760–1833)","priest and poet");
        putPeople(10,"Linas Adomaitis (1976–)","pop singer");
        putPeople(10,"Violeta Riaubiškytė (1974–)","pop singer");
        putPeople(10,"Gintarė","pop artist");
        putPeople(10,"Ilja Aksionovas (1996) (lt:Ilja Aksionovas)","pop and opera singer (boy soprano)");
        putPeople(10,"Indrė Valantinaitė (born 1984)","poetess");
        putPeople(10,"Kazys Binkis (1893–1942)","poet and playwright");
        putPeople(10,"Jurgis Baltrušaitis (1873–1944)","poet and diplomat");
        putPeople(10,"Henrikas Radauskas (1910–1970)","poet");
        putPeople(10,"Tomas Venclova (1937–)","poet");
        putPeople(10,"Mikalojus Konstantinas Čiurlionis (1875–1911)","painter and composer");
        putPeople(10,"Mindaugas Rojus","opera singer (tenor / baritone)");
        putPeople(10,"Violeta Urmanavičiūtė-Urmana","opera singer (soprano-mezzosoprano) appearing internationally");
        putPeople(10,"Nomeda Kazlauskaitė-Kazlaus","opera singer (dramatic soprano) appearing internationally");
        putPeople(10,"Stasys Povilaitis (1947–)","one of the popular singers during the Soviet period");
        putPeople(10,"Virgilijus Noreika (1935–)","one of the most successful opera singers (tenor)");
        putPeople(10,"Justinas Marcinkevičius (1930–2011)","one of the most prominent poets during the Soviet rule");
        putPeople(10,"Arūnas Žebriūnas (1930–) (lt:Arūnas Žebriūnas)","one of the most prominent film directors during the Soviet rule");
        putPeople(10,"Juozas Grušas (1901–1986)","one of the most productive writers and playwrights under the Soviet rule");
        putPeople(10,"Vytautas Kernagis (1951–2008)","one of the most popular bards");
        putPeople(10,"Mykolas Kleopas Oginskis (1765–1833)","one of the best composer of the late 18th century");
        putPeople(10,"Sam Black (1970–)","musician and recording engineer");
        putPeople(10,"Šarūnas Bartas (1964–)","modern film director");
        putPeople(10,"Judita Vaičiūnaitė (1937–2001) (lt:Judita Vaičiūnaitė)","modern female poet exploring urban settings");
        putPeople(10,"Algis Kizys (1960–)","long time bass player of post-punk");
        putPeople(10,"Icchokas Meras (1934–)","Lithuanian-Jewish writer about the Holocaust");
        putPeople(10,"Kristijonas Donelaitis (1714–1780)","Lithuanian Lutheran pastor and poet");
        putPeople(10,"Leah Goldberg (1911–70)","Israeli poet");
        putPeople(10,"Yemima Tchernovitz-Avidar (1909–98)","Israeli author");
        putPeople(10,"Ingeborga Dapkūnaitė (1963–)","internationally successful actress");
        putPeople(10,"Gintaras Januševičius (1985-)","internationally acclaimed pianist");
        putPeople(10,"Jurgis Mačiūnas (1931–1978)","initiator of Fluxus movement");
        putPeople(10,"Bernardas Brazdžionis (1907–2002)","influential romantic poet");
        putPeople(10,"Oskaras Milašius (1877–1939)","French-Lithuanian writer and diplomat");
        putPeople(10,"Jonas Mekas (1922–)","filmmaker");
        putPeople(10,"Algimantas Puipa (1951–) (lt:Algimantas Puipa)","film director");
        putPeople(10,"Balys Dvarionas (1904–1972)","composer");
        putPeople(10,"Vincas Niekus (1886–1938) (lt:Vincas Niekus)","composer");
        putPeople(10,"Česlovas Sasnauskas (1867–1916)","composer");
        putPeople(10,"Jonas Švedas (1908–1971)","composer");
        putPeople(10,"Oskaras Koršunovas (1969–)","best known modern theater director");
        putPeople(10,"Martynas Mažvydas (1510–1563)","author of the first book in Lithuanian language");
        putPeople(10,"Jurga Šeduikytė (1980–)","art rock musician");
        putPeople(10,"Algirdas Kaušpėdas","architect and lead singer of Antis");
        putPeople(10,"Osvaldas Balakauskas (1937–)","ambassador and classical composer");
        putPeople(10,"Nijolė Narmontaitė (1959–) (lt:Nijolė Narmontaitė)","actress");
        putPeople(10,"Donatas Banionis (1924–)","actor");
        putPeople(10,"Arūnas Matelis (1961–)","acclaimed documentary director");
        putPeople(10,"Salomėja Nėris (real name Salomėja Bačinskaitė-Bučienė","1904–1945)");
        putPeople(10,"Šatrijos Ragana (real name Marija Pečkauskaitė","1877–1930)");
        putPeople(10,"Juozas Tumas-Vaižgantas (real name Juozas Tumas","1869–1933)");
        putPeople(10,"Vydūnas (real name Vilius Storostas","1868–1953)");
        putPeople(10,"Maironis (real name Jonas Mačiulis","1862–1932)");
        putPeople(10,"Žemaitė (real name Julija Beniuševičiūtė-Žymantienė","1845–1921)");
        putPeople(11,"Ernst Glaser","violinist");
        putPeople(11,"Gottfried von der Goltz","violinist");
        putPeople(11,"Henning Kraggerud","violinist");
        putPeople(11,"Arve Tellefsen","violin virtuoso");
        putPeople(11,"Kirsten Flagstad","soprano");
        putPeople(11,"Solveig Kringlebotn","soprano");
        putPeople(11,"Paul Waaktaar-Savoy","songwriter and guitarist (a-ha)");
        putPeople(11,"Christian Ingebrigtsen singer","song writer for A1");
        putPeople(11,"Alexander Stenerud","singer-songwriter (Zuma)");
        putPeople(11,"Marit Larsen","singer-songwriter");
        putPeople(11,"Sondre Lerche","singer-songwriter");
        putPeople(11,"Lene Marlin","singer-songwriter");
        putPeople(11,"Maria Mena","singer-songwriter");
        putPeople(11,"Ole Paus","singer-songwriter");
        putPeople(11,"Marion Raven","singer-songwriter");
        putPeople(11,"Hans Rotmo","singer-songwriter");
        putPeople(11,"Kate Havnevik","singer-songwriter");
        putPeople(11,"Sigurd Wongraven","singer-guitarist (Satyricon)");
        putPeople(11,"Jarle Bernhoft","singer songwriter");
        putPeople(11,"Hans Erik Husby aka Hank von Helvete","singer (Turbonegro)");
        putPeople(11,"Roy Khan","singer (Kamelot)");
        putPeople(11,"Kristian Espedal aka Gaahl","singer (Gorgoroth)");
        putPeople(11,"Vibeke Stene","singer (ex-Tristania)");
        putPeople(11,"Stian Thoresen","singer (Dimmu Borgir)");
        putPeople(11,"Anni-Frid Lyngstad","singer (ABBA)");
        putPeople(11,"Morten Harket","singer");
        putPeople(11,"Tom Hugo","singer");
        putPeople(11,"Sissel Kyrkjebø","singer");
        putPeople(11,"Jørn Lande","singer");
        putPeople(11,"Wenche Myhre","singer");
        putPeople(11,"Kari Rueslåtten","singer");
        putPeople(11,"Alexander Rybak","singer");
        putPeople(11,"Njål Sparbo","singer");
        putPeople(11,"Øystein Sunde","singer");
        putPeople(11,"Jahn Teigen","singer");
        putPeople(11,"Joachim Nielsen aka Jokke","rock singer");
        putPeople(11,"Morten Aasdahl Eliassen AKA Opaque","Rapper.");
        putPeople(11,"Tommy Flaaten AKA Tommy Tee Rapper","producer");
        putPeople(11,"Lene Nystrøm","pop singer (Aqua)");
        putPeople(11,"Geir Botnen","pianist");
        putPeople(11,"Ørjan Hartveit","opera singer");
        putPeople(11,"Björn Haugan","opera singer");
        putPeople(11,"Ronni Le Tekrø","musician and guitarist");
        putPeople(11,"Knut Schreiner","musician (Turbonegro");
        putPeople(11,"Lars Nedland","musician (Solefald)");
        putPeople(11,"Svein Berge","musician (Röyksopp)");
        putPeople(11,"Morten Abel","musician (Mods");
        putPeople(11,"Jørn Stubberud aka Necrobutcher","musician (Mayhem)");
        putPeople(11,"Øystein Aarseth aka Euronymous","musician (Mayhem)");
        putPeople(11,"Erlend Øye","musician (Kings of Convenience)");
        putPeople(11,"Tomas Haugen aka Samoth","musician (Emperor)");
        putPeople(11,"Vegard Sverre Tveitan aka Ihsahn","musician (Emperor)");
        putPeople(11,"Øyvind Mustaparta","musician (Dimmu Borgir)");
        putPeople(11,"Varg Vikernes","musician (Burzum) and convicted murderer");
        putPeople(11,"Jan Garbarek","musician");
        putPeople(11,"Erlend Øye","musician");
        putPeople(11,"Arne Nordheim","modernist composer");
        putPeople(11,"Magne Furuholmen","keyboardist and songwriter (a-ha)");
        putPeople(11,"Tom Mathisen","humorist singer");
        putPeople(11,"Sigmund Groven","harmonica virtuoso");
        putPeople(11,"John Norum","guitarist (Europe)");
        putPeople(11,"Toki Wartooth","guitarist (Dethklok)");
        putPeople(11,"Terje Rypdal","guitarist");
        putPeople(11,"Ian Haugland","drummer (Europe)");
        putPeople(11,"Andy LaPlegua","DJ");
        putPeople(11,"Carl Høgset","conductor (Grex Vocalis)");
        putPeople(11,"Olav Kielland","conductor");
        putPeople(11,"Herman Severin Løvenskiold","composer of La Sylphide ballet");
        putPeople(11,"Edvard Grieg","composer");
        putPeople(11,"Eivind Groven","composer");
        putPeople(11,"Johan Halvorsen","composer");
        putPeople(11,"Tone Groven Holmboe","composer");
        putPeople(11,"David Monrad Johansen","composer");
        putPeople(11,"Trond Kverno","composer");
        putPeople(11,"Egil Monn-Iversen","composer");
        putPeople(11,"Rikard Nordraak","composer");
        putPeople(11,"Harald Sæverud","composer");
        putPeople(11,"Johan Svendsen","composer");
        putPeople(11,"Geirr Tveitt","composer");
        putPeople(11,"Håvard Gimse","classical pianist");
        putPeople(11,"Henny Mürer","choreographer and dancer");
        putPeople(11,"Ivar F. Andresen","basso profundo opera singer");
        putPeople(11,"Tord Øverland-Knudsen","bassist (The Wombats)");
        putPeople(11,"Alf Prøysen","author and musician");
        putPeople(12,"Peter Tomka (1956)","Vice");
        putPeople(12,"Rudolf Schuster (1934)","the second president of modern Slovakia (He is of German and Hungarian ancestry)");
        putPeople(12,"Michal Kováč (1930)","the first president of modern Slovakia");
        putPeople(12,"Iveta Radičová (1956)","sixth prime minister of modern Slovakia");
        putPeople(12,"Jozef Moravčík (1945)","second prime minister of modern Slovakia");
        putPeople(12,"Mikuláš Dzurinda (1955)","fourth prime minister of modern Slovakia");
        putPeople(12,"Vladimír Mečiar (1942)","first and third prime minister of modern Slovakia");
        putPeople(12,"Robert Fico (1964)","fifth and seventh prime minister of modern Slovakia");
        putPeople(12,"Maroš Šefčovič","EU Commissioner");
        putPeople(12,"Ivan Gašparovič (1941)","3rd president of Slovakia previously chairman of the National Council of the Slovak Republic");
        putPeople(12,"Jesse Ventura (1951)","38th Governor of the US state of Minnesota from 1999 to 2003 as well as an actor author and former professional wrestler; his parents were from Slovakia and his legal name is James George Janos");

        
        //Insert ContentValue Array using transactions
        database.insertPeople(peopleValues);
        
    }

    /**
     * put Countries to database
     * 
     * simple insert is used
     */
    public void populateCountries() {

        putCountry(10, "Lithuania", "Lithuania.png");
        putCountry(9, "Latvia", "Latvia.png");
        putCountry(4, "Estonia", "Estonia.png");
        putCountry(5, "Finland", "Finland.png");
        putCountry(11, "Norway", "Norway.png");
        putCountry(1, "Austria", "Austria.png");
        putCountry(12, "Slovakia", "Slovakia.png");
        putCountry(7, "Hungary", "Hungary.png");
        putCountry(3, "Croatia", "Croatia.png");
        putCountry(8, "Italy", "Italy.png");
        putCountry(6, "France", "France.png");
        putCountry(2, "China", "China.png");

    }

    /**
     * insert Country record to database
     * @param id
     * @param title
     * @param flag
     */
    private void putCountry(int id, String title, String flag) {
        database.insertCountry(id, title, flag);
    }

    /**
     * add People to ContentValues ArrayList.
     * @param country
     * @param name
     * @param about
     */
    private void putPeople(int country, String name, String about) {

        ContentValues values = new ContentValues();
        values.put(MyDatabase.KEY_NAME, name);
        values.put(MyDatabase.KEY_DESCRIPTION, about);
        values.put(MyDatabase.KEY_COUNTRY_ID, country);
        peopleValues.add(values);
    }
}
