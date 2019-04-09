//
//  LeetCode.swift
//  LeetCodeTests
//
//  Created by CF on 2019/3/28.
//  Copyright © 2019 SepCode. All rights reserved.
//

import UIKit
import XCTest

class LeetCode: XCTestCase {
    
    override func setUp() {
        // Put setup code here. This method is called before the invocation of each test method in the class.
    }
    
    override func tearDown() {
        // Put teardown code here. This method is called after the invocation of each test method in the class.
    }
    
    func testExample() {
        // This is an example of a functional test case.
        // Use XCTAssert and related functions to verify your tests produce the correct results.
    }
    
    func testPerformanceExample() {
        // This is an example of a performance test case.
        self.measure {
            // Put the code you want to measure the time of here.
        }
    }
    
    
    
    
    
    func testLongestCommonPrefix() {
        
        
        print("--"+longestCommonPrefix(["sepcod","sep","sepc","sepcode"]))
        print("--"+longestCommonPrefix1(["sepcod","sep","sepc","sepcode"]))
    }
    
    func longestCommonPrefix(_ strs: [String]) -> String {
        if strs.count == 0 {
            return ""
        } else if strs.count == 1{
            return strs[1]
        }
        
        var prefix = Array(strs[0])
        for i in 1..<strs.count {
            let otherStr = Array(strs[i])
            var j = 0
            
            while j < prefix.count && j < otherStr.count && prefix[j] == otherStr[j] {
                j = j + 1;
                
            }
            prefix.removeSubrange(Range(NSRange(location: j, length: prefix.count - j))!)
            
            
        }
        return String(prefix)
        
    }
    
    func longestCommonPrefix1(_ strs: [String]) -> String {
        
        let count = strs.count
        if count == 0 {
            return ""
        } else if count == 1{
            return strs[0]
        }
        
        var prefix = strs[0]
        for otherStr in strs {
            
            while !otherStr.hasPrefix(prefix) {
                prefix = String(prefix.prefix(prefix.count - 1))
                if prefix.isEmpty {
                    return ""
                }
            }
        }
        return prefix
        
    }
    
    
    
    
    func testLengthOfLongestSubstring() {
        print(lengthOfLongestSubstring("afsfsiwefhkskbuaywyexverfb"))
    }
    
    func lengthOfLongestSubstring(_ s: String) -> Int {
        
        var map = [Character:Int]()
        var result = 0
        var j = 0
        
        var str = Array(s)
        
        for index in 0..<str.count {
            
            let char = str[index]
            if let num = map[char] {
                if num >= j {
                    j = num + 1
                }
            }
            result = max(result, index + 1 - j)
            map[char] = index
            
        }
        
        return result
    }
    
    
    
    func testCheckInclusion() {
        print("--"+String(checkInclusion("xuumbjffxuzovdwrnolopeingppzgorotzdqfprokkmucxwsub","jpdojwinknmyeorfdhpsysyealozhgbapagzjsivbxmcyijlbdafupblrawguoazuzcqupobxayrkpqxawytdsdznljnxulaugewrbjmkslsrllixpkuvorhnnhkzikovsajrbhjdybocvjloqiikidsnwcubhliajwwqkpqaugidhfxqfxrkluvadcdmekdhckszpojvwpiquazmaecaxxwsnswzxbctqeqhjsrgnjsjmaqbexexuwgfglixsthifevokdgexxkdmzaxrcilmthzemuomexwzipzivdyxqnvgzpjavonrkobmgkormdmfiwwalgdzwlngkrjmdwkknajqatghoddybqfkorhpmrkfcfwsaproaenfedvfendprnlpmuqklsqrsjuejyxulfuhdsyolthhhfhmxorojnjsvqyworupkdzhyqkzikvhltfsrhrecmyyddtinphjsmmbdtrouyifvsvvlamwhkffrrywdiawpvxwcwfkcunbjaelbcmdwczikkfelahowtbwqbdcjggnmknfhjdtusfjotsbjgtlnuonlxjlcwyqiffktonvtrkcogosfbcvcosktnvbeitxuqpexxejnklndzbtzlzeebwufoiwqqcoemnshcpovntjgidophekyntcsrwzvovwmostqudxgeaowehcmqmdrllovmmbgqhaxrqluizhhhslystwkhckjtosnomfvyibkasycxnnmvkbwkbhzeayezughsmqovogrnihjgetsdvhymjmnijzwvpasurcaybmyzfbqepjsdqwmkmomzkociaqtnkwiguylhwxrfamyxjvfxwonwblidvcsenvwigjjqdsnnydlgdhlsdtonvuapzaozkdtyiartimmpwgotnwpiwimbdunqfickerusbvrqwazvnwgdczvnqtigjmkjgsridfulxjekazzqkdynyuutyoffhntfbcruhrmnhhjyyzfszbaqykgnroepiovqqlhdtkizvpivukdutitwzhapvcyfghqvtjyyrdbctvdccoxjtsovdosbyqaiffumnrfokrbgvedxbcytvbcaeoviutdmxwfhxgchnusazcztitxgyjrkjdmajbndlemsnpjwzgvpitrfrjoxivhisgkzncmkewphusvaycteennpltuevohegzvafwxuebmovgkpwlgyoutsbbgxoxdzyisersgaqcnnjnjtjwufqscjzccudbkdcnmorpmraqapvirijlpretmezlrbdvnfixvmalzmgrhwpkhisaztpsgvlooqxezzscjrtnmmctoyinjermwrrmjlfbizryripnarkvnabdizzereczdnbkojpfmxhlfvlztmzpskwttzyusxaudprxpbpihorlipzpdiucpvrqlscmoipvdzsrowjrwmxzomtcxxehrmcaxmtifcvftywjkzgdsohvomcthhylzpijujfyysbientozyirurugevubxpdpbihrudvgdmhwyxuhyorvufffqzifwzszmfswhkesywfyozffzarrklnxppymoaslqctlfbtrykccmgmhrdacuelfrbflsjxhdagaevscxerljtxnwodtfioyxjoaxyhzjmttvflfhqvvcbwvmnulcsubtwngjvomqkqrjtntkzuclolcjmiypjilgvezphjqrjetqnaccrjmxydmmkbmuyxwotfynptdotuaxpxzgjulwgwfbprzolxablskvidnmnzcofemsodetsiubqrvtbkshuokkuomjezwbmtcjvapnlsmutehyfxaqjqlibfzitcfhuivmmclulnrwyknbymyfcwbgyxtavcaebvfwlkikylkrpcfappcamnjenpggoxcrpxdbqjqzrdvnfzxuxuaixbpiqmitzhefcgyhzayemxgrtdoiryqguiexsrysetobkqnfphdechsgoqvmdhurzhvflsbxsdjemmvlzpthrjizfcayxemztvszhhpfvvjgoejrjnmyvxstpejfmiukuocmrgvinqifpdcqvwfddoiyopbzverxwcqdyoqzeqcjcwmojbhcnrksebanfpdhhpiaguxracnxzttbjgruczuhwwjbmznzgdijyemrwcawodqftjtlyozqwwchxtlvlnjqwklmbzirfhaquiltdijijeglroopaagmyrkhqbnkhbxvguodmmszfoomhfvwjsnrmmzjuyxhotehlezyyiptzububvazwzziskqagtpthflchvvanpugjpeoipecmvgkocylsqduwbreeifhjdomajmnbwrmxuhvvjnfblyvtveqalkqlbxkxvmxfefvijptnpvhmgmotrvsxmarhkspdlybniuoxycahgisvnrlrukendhsxvvcqzinnbkryzwbnktsgfwxjklrcgvtrzvkqfbhctljoijsvxbnwiunrasctvuetwvzdulmlnxeivsvujihlmjroxntmgkecjkimcsvfesfeursbuchaexgpyqakllumehlfdkuzbnulwfdacxjalozmrneqtjvdpgkcwnrkuhhqbnpedmysjqcrdqaawiwcucuzlbkwozlgrgcroyebklrwzkqicuqezkswayknmcytcsrtkxkfwxmimpolrqzjwfdzmlkpinifykobpvqlzqrcliorfqygytfgpdociwflhwpuuumrwnhrkpnteqacxejyulkccgxtnsfhuuahifvsshkwrkhptqvcmylyvvykwjhgknmsuolomginxdfwvqpfwlpwvommjjymsunxmbjxlcznmefzvuckeqfpighnxzxdpdlcifxbzldjctrswxmrxcjbbtivfnwqelhkmbunsroodysywhjsysajsrngtsvimguuwaicmuqzmafocvdzudgkmmvhydmafxqrrpkvvnnjyzohjwtjgqbrptggknxpuatfycatgimywhbafhjazjklgzxaiecmqbqgwgdepfspuxakrowawfolujdcyqsmakrkiqiduitooygdduztcquxqyraxhwjkvybbyiksqyqxqfmyzjyxxrxktmfklcjsjeijjflvtjayqlfuqtacxrfbrsdqtuwmflpdtxtjezsgeoeeyhcpncbknslbexvicfxslnqbelcfjonoakbitkizdlmusmydyajmiiouvqhhpmjspwoprvajocrloqydqbrgzxqafbfonuvecxjcrpoiorfqxofionzmomccxkhjqzkvpdevkwpsikonjxfthvtorexdyntvhttbtygzmtrrzprsgqnvbzhxuiruhugtaogfrjqdxnilxatjyltpbchjlkajaxefdjjwhqzjeejznbjkhdjqoltccfgosuuxodgyhvufwdrdxtpuvxlthxibekzkdoufkbstuxhwukrfaqsbratipaaxjawndpognykgltxofqbypomdpdsgncggpoddzbobloikifupdfgytydhxoxtcyerqpgezsddndikvcwufcefpdkdgvrlmvoiadawofsuyezliebpixyqboteavtvqeojxmemrdbptsxdckszxjgveaqngboxfdxqdgddczdzpyhlztthvbzgutaioqswwpzupddayzktwvqyvxcflmolxyewseqrrvpovpeftwgiywoyflwejpffxpubejlwmazjzfcldadgnkkjtmxktuzlocvqhjajqrfrfaloychnmokakwsfkrtacwjgsieptnujtgbbwzllvkpeuewegmkchhaaaptmbmoybtdotctkfyumafregkthibmufiudjrcohdhuhlpjeishhekicdfiiostjmofwhreoegrnbqgkhmiezgtasdaqdcixsrdfdsfcrgjaryeqtkussultserwmyealuvxckhcgojsxzsfxmrtcfhqpowalbbzvpcltiwdhexbvcjojdptxeplgestsnpmpibymzaolqaybmeezyagvvftcuqgqrpjauxjnmudeasbpeormqofrbmmgorysyztkbloyfjikxdrytsdfdrjagghbbjqkujemzvvtioluzitrmaxjphducstlearfirqknijfdurdztizvwoeqzamxkbbvmnbxomhsxfmwdhocdyabcygzojqebxferyieqfislcpwiaadbarnsgnuvhkaidexxcgxhmvsiwqhoxkjwvycbyaqiddlrgsvqvzkvqzeewbxnfqlhavmqyucnnlskzyhwlnpglakbstcsnmsipeekjbwvokjjasfcruinzkcmjtkuztnglqakavnjmvccjgquzfftcqzwnrvywoqxhzbkbjufjuyqqqtaoakzbykeraqalcqzuhjndgusnvdanqrwemqsmcwxelogrfxxsdyzlbfuvopxsyzuizshrtauculajiapoentvnkxpvyfxfecjolvlezsmfmibhptmgdkiucnsralqhtutgvnpzicjwcgrtcgyueuqsxnyspxmnzhupjwalphkutczrptfxsvgeikwqqhesezmkoliizhceciotrcrjhunyfnpeyrnmucyhkozbipsmuqfgujshzhzuxextaapmrbhvexaqyifwrodhftkwbpyndylvfukebddabmjperimjtzeeqwmjzjxjrqglwcsuxinztzxpzfdlirmyroecjkimmgnybedfhssjfzzdnqlzihfgobikowitiqdyzlhxbxifamfkeienxqvcmvhzixicqlylurlfnzbrfoztfjxswwlxkvrhueccohddaazuluirluhzliuqeqiajvmvtbpibfhiulyagqfowibqjkjewqminwsuupmxnijyrbiodfknndgpfiannwlkillxmirfqmmoktexmoqxqujogmxjmkenfphffmdfablsaqxufjwvmufogrzjarlopjhidbfbhoivkknzgqresjprfknjetohwtqurxyngxilywmbgpsctswswwkasyisochqeslbiunnbgxsgzwkopnhgdjyuherwtrkypbjrdesztgkxzueqrhhicwndmidmqahdwcycqpgtuildbowqhjaqnmblbnvvsxahycecvfnbvqzcjburykyjkgazgauobvieoerphnehdjxfianvcaasrctenrcwcgzcqbzufwsqllzbxnjzktgermrodlzuvkdblqcwbfjevjkygbgoalqyibexruhsxsowmchcogiffedbuddithpwocmovwbpvxzhwmyzpuwdhrorlqxxtqtwswmdcszbxwyirhpwjjulqoovmgqydxctjrnncsfevitouvdvsgdftpyjztxrxhuggdtyfandnuvufixthdxidrlzzkssngvrmtkwzifwjoqyawcohqxrucjixdcrhgybujxpbjfwxunbbotjlijfagrdsbeemkvgaebuagweegcgpoleicaakefhgvgjislsamatuqmmjisifffwmigqwxaywwmoyzarwtpiimekzofbycyoqznbnqwnncmzoiwpjgpymvynrgasxpekunmzksdrfxlyxewqmfoeufccrwevhhxxjqzkptkctaqerwotatqgkbnjqbpfyglucttnmxpxrrjhglbmzzjtyupaexfismwrvfgtunlriabhhyklpmevgmltnkdttjmemegytzzikcykidlasvugyzfaozknksednbsdcfnfwtozioavvipvsrkztslcxqgrccocxtwnxobbhidcublbnpwhohqjcxwfftmptlwtpjugbchgxahplumbjqjfvljhqzmbdsdeemxevugsthrveucyqxdktkdymznwdvkuoytvfrrfzrmlnedhckhngadcpugwzfupcudmukkpzrtdqvpcpzspuhdfoeojybisjmcjmcyhiiqjnfkcpepbflwfwmorpgwumlzynzpbbvvrgtxpsgzdelmlohavhyqhrfztmncnllnfdgdotoiojwtwilwwdszhcqbkdwtyrurxkzgcwrcvqlhynujihfdbwnnhkwdmfwciurvrqkmyghvhftbfhjogfrrslmuzussufwkkiewfevkvgalhyutnfxzgxbifjhbqolbsanvwkhyfxywfbvxvoiwcqhvdypwpgquutrugldizlvqaeeboriznjxovvmbwqyrxmxqilplplszubphmeszzrfjoliuskludoukazpiezpzucrsiiiichlxthowlcbmmfnyjyylgrcseraqtwodnxvugpysbosancqgzmxinonoeqmvyumsdwjncgztbepamqupqvxzudrniawehxilhybtdsupswxzjfhhchdeqoidvigjhkonfrdskxvoskgezzhhcpcfodahrlnkoldcdomllfcywrtqofedeychinhsvcssmgbadabdgyvmscucbckahgjawopdwlixbkmlxcpxtaqoempcldkefcerzeiowhgyhreveztowuigsgwcvdjahrfvrvvubliwretdwqslwgusqoqcczbzdalaocaarmtqhgjtzjjwnntuezwioelmwxnvnfeeggjljuybgshzeqsongxutyjovbklauknymkkkmnnwqxixaiwaxfbysglyvazrrcqcbgepgegwlmtycljiaqivlscezkquxkgzubqnbdsfxditryyagiihyoqdhtudnfmkwaohttygtwesumjjivazppjzkbdywdfudbjkubytrfasxkxqmdgnirqronvypulppeaqbjimtvffglxvihsvesvhbagtuikytbocsjnxfoxmtwpfwcdadliexyisjopbkqbjhlflqyxnjdkqndjpbdehwfsljapruwbslzchkyvsmcvocictzqxcktfmoathqnxmlqirfjezhqbboupnzlyqmiqiqkkbhwhpcyibipmizzxhlbjffxdzigymhjgyowmrjouvfjwgyzdovyslmfbplvjnqvfdbfeqvugoqdzvtggrpueutlljsfgudmgrzjqiaghatyzwjbkxxadrwjohhqmnwrswodapavdwyvwicbignxagbqodjeihgvwbdlexjcrltkidjdzjjteihgwedogtxafmajjgfgprbtbktqvirgxvvakqhbvgizxdgmabszclfbkrchaubgcobhpqrtfjbjzhpllxyvuqinnnkzdwqxzjjbniytymygnjzmklhpvazfqcdhafvoxlkxnvsmzfhjcqwdzqmlblhduduwbpbwonfmfwwbvhbgoyhwlmlxfnhlfpzwiybgeqghufeqilmdxzcdwrdwiculhnhzxybxvkwpjbwyprvtphhhqsnukanpnzoxtumxwlgostwbgqmtvdzsecquyrircmlckkzviczrvtkzyazlihddrlohyrovhprvcsmjrbxjaivvgolidxbyvxgkflallznsylhuzrkhrvfakpbhwhrgtwnlczewkyxhcturbfbfvlwvhaykumdftqbkmdxutbnphdsgplxxsdkcfouaprhecugnzdsjdyjkkuvtjtberlrwxhddmshcoyzlrgwugpnozubiglbcjwxjnvnmnbdtvlfbqqijwmdkrzslhsvnxnrsdbkbyxfkluvtofyesakxclxvodsuxwlyqkoyhynxfmpvmecqxxasvmsdrandljnyeepxaiwdvmmrzxstnzzfkxjsflkkrabqkicjutpyrbaewqzwfwdhzjqibmqhhzbnoaucsbpjtvvumkpaehnxxsjgkfpbfannzznhylowtsnilprqrbohrmcucboxzqwnbkbkgldydkqqqgjbtxavejjlxfqweybeaczszapiqiqoqwzhrvnjlmjmdmyyziqcusbpyxqwetclyrhfjrgzxbydajuqnbxhmjgenskqjikmgqlpbmsvuuxehfbydyqvgdfnkdqhlptgaollttiduybwqgaaatmcvdhagbusjrjigyhcphyhowixnezvioigsjdosikthzijrdvsfabprlcmjtjekculxcoyvypsozolqezlgunkhsftyjrffpfkuxbuoolragvarmtjozwqfiqdlaldxdauwzdrlhxlghtovdwesahmzklfoywukjufdiyiepnyjqzqbvomvefaahlnbgjhvumffksfvomrbnfstssvdgpubtmglxicclsijqumvibauoaxvgteljaajfcrqadkxbqrgbwaihxdsaisopmmwbzddapbczwnfnxspgtajjswcubnspwxglemattdgijkavsoanafyrkczcvmxzciuvtiwnraibtfrdqcntksioxjlzstxivizavgurmvwphdfxcvwqicctqicommgehtlunpbknkkklbzcjrxcxjchbszlqhtcdkzbdktkffbbwufcvscjsaraktaatyexzjxvxvoyyzivxpmwuxxkjdkrrmfegzkevmaeotwvpcrjtbfsblfdebacvomgtudrlcrjktvwdaerlafaqfcopbqxujngvxmjelcuesauyxuazrhiztlapgvsdenyqpafckjzohjjbdosjyvombptrppmanummqvahchtqkjdppwwskbygzaqpjlxkiposgfwltwlkvowynkcytprknckyppzvjjqaqibhakstpgkpbhviuqdrnsazdfptdmheqeusmkskdldaqnxthokukmhcpssjrtjnemyvlsaeryoeiclipnrjmbiyzpzfprjeyhphuqtdgqsgmicalezpyoakygeorrhzuyzhqqddhrygeybtoanobkvbfgpchrbtqbampimgefkyrkdfqgwyulvqbzljzbrisjugfjpruwilxneypgflzfldsbkpymcmxfpedmwogtxqrifposbwmohakknpkdbdycsgetahejtlqjaoumqyjbxywbmpbtcgquedhtfbbptomabbnahguvzsayqgvqxolvuflfjfhvmilqdzwqusvlcgemlaouwlgluuqtrqlhwooretsjjtnpnvrpnicakqcfuxotzmvqhsvoptvqiletevbhfbrolhijwidauovqlnqwmwvfoxljrbjtbwuazkhpnxntigrbdlhwbtwtzlnginyooppgpilsuzzjvfhanrggtxcjfxmvgbfsipktduomcoukthptkxahkkivmbnikapysfahapdembxvuakdniziuslabaotlifsolqboplhuasrlawpjsjaheapmubdtysalursciiukkgtrkzmqaltyksvdmomgydqqswpkqmewzzyxifqiivisommszulngjdsovkgsahicjhnlxqutcsyhfhxxyamenvwbruzzkywgmcmnqzvkindlsworliooqshsbxvoctrjionbzsihjhfitybhqyajludzdmitakuritzrgpdkvqptsmrqojcagmrhjppgsovqgrgjzdpzmjcrjbqprzbuufhwjlfgjwokimhvihgkgnkuajkpfsbiragdwbggbjesipyihpinhcrhpobdiaasfdivbsjpqeobgbzszqdkoixnhihncdutlggytzukcbtrdvxgbdllkswarjqehcdddgqdvwxgjtyymecyvqsutnpnwygxvlxxrpggidpmoygidulrdnixkuuiwmigcsntnlvomivajdmmopbyqljbmkqueawblhaicmshjhwnxieiftzjwwrwameuuzcoqiuibpcsaajzdciyxsqaeubgixinvwlecbkrctrwtoskgbdjbyjlgvmydlqrymdhyfdqawurvxprrnfnymfuvenrfdwpnxfqsbylqfokjnmpvnrtoqnhzpgzsebieouetuuruwenrjbuwondepkkuvxfzyswbnlykxglazitalhyhtksszzhglorprfobxkihnwxghhybaaspqmucv")))
    }
    
    func checkInclusion(_ s1: String, _ s2: String) -> Bool {
        
        let count1 = s1.count
        let count2 = s2.count
        
        
        
        if count1 > count2 {
            return false
        }
        
        var n1 = [UInt32](repeating: 0, count: 26)
        var n2 = [UInt32](repeating: 0, count: 26)
        
        for i in 0..<count1 {
            let value1 = Int(Array(s1)[i].unicodeScalars.first!.value - "a".unicodeScalars.first!.value)
            n1[value1] = n1[value1] + 1
            
            let value2 = Int(Array(s2)[i].unicodeScalars.first!.value - "a".unicodeScalars.first!.value)
            n2[value2] = n2[value2] + 1
            
        }
        if comp(n1: n1, n2: n2) {
            return true
        }
        
        for i in 0..<count2 - count1 {
            let index1 = Int(Array(s2)[i].unicodeScalars.first!.value) - Int("a".unicodeScalars.first!.value)
            n2[index1] = n2[index1] - 1
            
            
            let index2 = Int(Array(s2)[i + count1].unicodeScalars.first!.value) - Int("a".unicodeScalars.first!.value)
            n2[index2] = n2[index2] + 1
            
            if comp(n1: n1, n2: n2) {
                return true
            }
        }
        
        
        
        return false
    }
    
    
    func comp(n1: [UInt32], n2: [UInt32]) -> Bool {
        for i in 0..<26 {
            if n1[i] != n2[i] {
                return false
            }
        }
        return true
    }
    
    
    func checkInclusion1(_ s1: String, _ s2: String) -> Bool {
        
        let count1 = s1.count
        let count2 = s2.count
        
        if count1 > count2 {
            return false
        }
        
        var n1 = [UInt32](repeating: 0, count: 26)
        var n2 = [UInt32](repeating: 0, count: 26)
        
        for i in 0..<count1 {
            let value1 = Int(Array(s1)[i].unicodeScalars.first!.value - "a".unicodeScalars.first!.value)
            n1[value1] = n1[value1] + 1
            
            let value2 = Int(Array(s2)[i].unicodeScalars.first!.value - "a".unicodeScalars.first!.value)
            n2[value2] = n2[value2] + 1
            
        }
        
        var count = 0
        for i in 0..<26 {
            if (n1[i] == n2[i]) {
                count = count + 1;
            }
            
        }
        
        for i in 0..<count2 - count1 {
            
            let r = Int(Array(s2)[i + count1].unicodeScalars.first!.value) - Int("a".unicodeScalars.first!.value)
            let l = Int(Array(s2)[i].unicodeScalars.first!.value) - Int("a".unicodeScalars.first!.value)
            
            
            if count == 26 {
                return true
            }
            
            n2[r] = n2[r] + 1
            
            if n1[r] == n2[r] {
                count = count + 1;
            } else if n1[r] + 1 == n2[r] {// 原来相等
                count = count - 1;
            }
            
            n2[l] = n2[l] - 1
            
            if n1[l] == n2[l] {
                count = count + 1;
                // } else if n1[l] - 1 == n2[l] { 居然不行，野指针
            } else if n1[l] == n2[l] + 1 { // 原来相等
                count = count - 1;
            }
            
        }
        return count == 26
        
    }
   
    func testsimplifyPath() {
        print(simplifyPath("/../"))
    }
    
    func simplifyPath(_ path: String) -> String {
        
        let array = path.components(separatedBy: "/")
        var stack = [String]()
        
        for str in array {
            if str == "" || str == "." {
                
            } else if ".." == str {
                stack.popLast()
            } else {
                stack.append(str)
            }
        }
        
        if stack.count == 0 {
            return "/"
        }
        
        let result = NSMutableString(string: "")
        for str in stack {
            result.appendFormat("/%@", str)
        }
        
        return String(result)
    }
    
}
