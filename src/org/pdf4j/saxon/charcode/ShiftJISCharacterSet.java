package org.pdf4j.saxon.charcode;

/*

Copyright (C) 2006 Hewlett-Packard Development Company, L.P.

The contents of this file are subject to the Mozilla Public License Version 1.1
(the "License"); you may not use this file except in compliance with the
License. You may obtain a copy of the License at http://www.mozilla.org/MPL/

Software distributed under the License is distributed on an "AS IS" basis,
WITHOUT WARRANTY OF ANY KIND, either express or implied. See the License for
the specific language governing rights and limitations under the License.

The Original Code is: all this file
The Initial Developer of the Original Code is Lauren Ward. All Rights Reserved.
Contributor(s): Integrated into Saxon by Michael Kay. Removed code to perform dynamic
initialization of the boolean array, replaced it with generated static data.

*************************
Author:
  Lauren Ward
Date:
  February 01, 2006
Address:
  Hewlett-Packard Company
  3404 East Harmony Road
  Fort Collins, CO 80528-9599
Revision:
  1.0 - Initial creation

Description: This class implements the PluggableCharacterSet to support
Shift_JIS encoding.  The character mapping was obtained by extracting the
Unicode values from an iconv character table (sjis=ucs2) available on HP-UX 11.23.

The class was tested by transforming numerous manuals and having localization engineers
review the output. The class was also tested by transforming a document with Shift_JIS
set as the output encoding, converting Shif_JIS output to utf-8 using iconv,
and then comparing converted content to the same transformed document with utf-8 set
as the output encoding.

*/

public class ShiftJISCharacterSet implements CharacterSet {

    private static ShiftJISCharacterSet THE_INSTANCE = new ShiftJISCharacterSet();

    public static ShiftJISCharacterSet getInstance() {
        return THE_INSTANCE;
    }

    public static long[] flags = {
        0xffffffffffffffffL, 0xffffffffffffffffL, 0x3588ca00L, 0x10000000100L,
        0x0L, 0x0L, 0x0L, 0x0L,
        0x0L, 0x0L, 0x0L, 0x0L,
        0x0L, 0x0L, 0x7fffdfc07fffL, 0xdfc0000000000000L,
        0x4000ffffffffffffL, 0xffff400000000000L, 0x0L, 0x0L,
        0x0L, 0x0L, 0x0L, 0x0L,
        0x0L, 0x0L, 0x0L, 0x0L,
        0x0L, 0x0L, 0x0L, 0x0L,
        0x0L, 0x0L, 0x0L, 0x0L,
        0x0L, 0x0L, 0x0L, 0x0L,
        0x0L, 0x0L, 0x0L, 0x0L,
        0x0L, 0x0L, 0x0L, 0x0L,
        0x0L, 0x0L, 0x0L, 0x0L,
        0x0L, 0x0L, 0x0L, 0x0L,
        0x0L, 0x0L, 0x0L, 0x0L,
        0x0L, 0x0L, 0x0L, 0x0L,
        0x0L, 0x0L, 0x0L, 0x0L,
        0x0L, 0x0L, 0x0L, 0x0L,
        0x0L, 0x0L, 0x0L, 0x0L,
        0x0L, 0x0L, 0x0L, 0x0L,
        0x0L, 0x0L, 0x0L, 0x0L,
        0x0L, 0x0L, 0x0L, 0x0L,
        0x0L, 0x0L, 0x0L, 0x0L,
        0x0L, 0x0L, 0x0L, 0x0L,
        0x0L, 0x0L, 0x0L, 0x0L,
        0x0L, 0x0L, 0x0L, 0x0L,
        0x0L, 0x0L, 0x0L, 0x0L,
        0x0L, 0x0L, 0x0L, 0x0L,
        0x0L, 0x0L, 0x0L, 0x0L,
        0x0L, 0x0L, 0x0L, 0x0L,
        0x0L, 0x0L, 0x0L, 0x0L,
        0x0L, 0x0L, 0x0L, 0x0L,
        0x8accc600b012L, 0x0L, 0x0L, 0x0L,
        0x1000000000100000L, 0x0L, 0xf00000000000L, 0x280000000000L,
        0xb190202681f80c04L, 0x2000c3300000L, 0x3300000004000000L, 0x0L,
        0x200000000000L, 0x0L, 0x0L, 0x0L,
        0x0L, 0x0L, 0x0L, 0x0L,
        0xf009999c9c999999L, 0x2010000000000000L, 0xc000300cL, 0x313000000010000L,
        0x600000000000000L, 0xa000000000250000L, 0x0L, 0x0L,
        0x0L, 0x0L, 0x0L, 0x0L,
        0x0L, 0x0L, 0x0L, 0x0L,
        0x0L, 0x0L, 0x0L, 0x0L,
        0x0L, 0x0L, 0x0L, 0x0L,
        0x0L, 0x0L, 0x0L, 0x0L,
        0x0L, 0x0L, 0x0L, 0x0L,
        0x0L, 0x0L, 0x0L, 0x0L,
        0x0L, 0x0L, 0x0L, 0x0L,
        0x0L, 0x0L, 0x0L, 0x0L,
        0xf7fffc0800000000L, 0x7fffffffffffffffL, 0xfffff01e7fffffffL, 0xfffffffffffffe1eL,
        0x0L, 0x0L, 0x0L, 0x0L,
        0x0L, 0x0L, 0x0L, 0x0L,
        0x0L, 0x0L, 0x0L, 0x0L,
        0x0L, 0x0L, 0x0L, 0x0L,
        0x0L, 0x0L, 0x0L, 0x0L,
        0x0L, 0x0L, 0x0L, 0x0L,
        0x0L, 0x0L, 0x0L, 0x0L,
        0x0L, 0x0L, 0x0L, 0x0L,
        0x0L, 0x0L, 0x0L, 0x0L,
        0x0L, 0x0L, 0x0L, 0x0L,
        0x0L, 0x0L, 0x0L, 0x0L,
        0x0L, 0x0L, 0x0L, 0x0L,
        0x0L, 0x0L, 0x0L, 0x0L,
        0x0L, 0x0L, 0x0L, 0x0L,
        0x0L, 0x0L, 0x0L, 0x0L,
        0x0L, 0x0L, 0x0L, 0x0L,
        0x0L, 0x0L, 0x0L, 0x0L,
        0x0L, 0x0L, 0x0L, 0x0L,
        0x0L, 0x0L, 0x0L, 0x0L,
        0x0L, 0x0L, 0x0L, 0x0L,
        0x0L, 0x0L, 0x0L, 0x0L,
        0x0L, 0x0L, 0x0L, 0x0L,
        0x0L, 0x0L, 0x0L, 0x0L,
        0x0L, 0x0L, 0x0L, 0x0L,
        0x0L, 0x0L, 0x0L, 0x0L,
        0x0L, 0x0L, 0x0L, 0x0L,
        0x0L, 0x0L, 0x0L, 0x0L,
        0x0L, 0x0L, 0x0L, 0x0L,
        0x0L, 0x0L, 0x0L, 0x0L,
        0xd1f6cfc2422462d9L, 0x341707c720005002L, 0xa6fa6cdbee9e9220L, 0xeb370fc71c06a310L,
        0x4067c02c00018aacL, 0x1307d57e00419619L, 0x12954294c0170601L, 0x3822c9b55c0316a2L,
        0x6556a615efc0240L, 0x11c1862804082e84L, 0x840440e0000c3d02L, 0x2465462215060450L,
        0xe8402ea140202139L, 0xdfdea82824fe4788L, 0xa66df740aef8ff04L, 0xe5c021cc364c6e6L,
        0x9bb249040d6293f0L, 0x193d0a121c61fc05L, 0x11c46811907c4c4aL, 0x554425c7bb0034e3L,
        0x66858764d02150f1L, 0xd7e479aa8243dd91L, 0x280002a186c69210L, 0x30fe0b517cfff3a0L,
        0x58ffc015825e02deL, 0xa2e2400100a0d71cL, 0x8a1ba0002c99308eL, 0xe9c0008066c62024L,
        0xb018a00000350c2L, 0x8e09130c1000001aL, 0x997000ef01fa8200L, 0xd00082918000146L,
        0x2400b9000416a80L, 0x200a801008b808a0L, 0x83210800a4020a08L, 0xf08251b29002b065L,
        0x98d5328903848190L, 0xa123c0004a600001L, 0x20d01000b8209000L, 0x92123a0990000968L,
        0xa63004444821cc24L, 0xc03069e22050a442L, 0x14001109009210f2L, 0x452855cb0c1be17cL,
        0x206186f8257e6182L, 0x9c3cda0a5ea1884L, 0x7824125414882052L, 0x250d86806b00211L,
        0x504040a984410608L, 0xc240002022280001L, 0x20300000000eL, 0x6058830052400030L,
        0x5802002028a202L, 0x9400cdbd1e50d4a0L, 0x95dd05fd3e029ec1L, 0x3f48b8176fd296a3L,
        0x6ff75220a88440ffL, 0xc6b7d402cc0b4240L, 0x8c80040d8539aL, 0x5000040c0e58234L,
        0x1124ff120400000L, 0x1aa00800491200L, 0x29188004200a012cL, 0x4c321657927d16L,
        0x3218427404159384L, 0x9d0a0d0178003effL, 0x5921072883140780L, 0x70e19235f0c8dbbbL,
        0x587ddf910745458aL, 0x40aa534c627cd149L, 0xfdb8f1c2c0e6184cL, 0x140c03cc8810c495L,
        0x3a65cc7f14020L, 0x7234a461bcfd8500L, 0x585c2b3193603e8cL, 0x70050a9d180db70L,
        0xd2c704314188080fL, 0x29be14e53593df02L, 0x2122ca60095a2222L, 0x13fc800012002bafL,
        0x80eeea374223b891L, 0xc1d614929082424bL, 0xb8607f9a0018445cL, 0x27edf9dcc00f5703L,
        0x61c8404101910027L, 0x4d850801d22330L, 0x90cb2291f5f82c12L, 0x9a41a23050420a20L,
        0x2051308028c0a22L, 0x20020080014102a0L, 0x108034220c56a058L, 0x650428a0f3096a26L,
        0x8400008c18390fd3L, 0x48547c63208ad80L, 0x31cac1594d1d814cL, 0x5e192150e7cc4030L,
        0x332b180985850e09L, 0x785120072bc38a20L, 0x59c24384221208caL, 0x4940026c8240bdcfL,
        0x90d50f1703be4ba5L, 0x4243d24bfc25f50bL, 0x558852ce2411bc0L, 0x4a23d8a6294b5c13L,
        0x38001302607028ccL, 0xf286d84d11000b03L, 0x54051915a385d668L, 0xa742da1d1032060L,
        0xcc9f207876a08a45L, 0x201c6ee0371dceL, 0x60224c1881026813L, 0x513e90c601942055L,
        0x24383953707206e4L, 0x99000c162002081L, 0x88068108b02a1090L, 0x7000503300a00030L,
        0xc202205d10021e6L, 0x114a98517a6118d1L, 0x9a74068208317d39L, 0x8616389100191000L,
        0x81591018000982L, 0xe0028527a0a0b026L, 0x708cb270601250ffL, 0x4c68155474a1d000L,
        0x18215304703696L, 0x4c0000681a6a09c0L, 0x48a145800012488L, 0x871864c24aba5570L,
        0x5f01475de5f00a2L, 0x1026029101132203L, 0xa009828d24212324L, 0x2c585c0600092983L,
        0x62415c00b0186083L, 0x440008990a0788a8L, 0xea02410058205040L, 0xf2000c91c81b5222L,
        0x405144b70308a002L, 0x840801011808cL, 0x622040000f10e0L, 0x91004500004044L,
        0x40086842000208L, 0x4a06402f4a0004L, 0x8a10c4100884042L, 0x10c2ad01870e0459L,
        0x204801000aca63fL, 0x839820d561402846L, 0xe1002200a1092240L, 0x3a02a150e04c01ccL,
        0x20031d04730b03L, 0xc03010010a0a4b0L, 0x950020000403010L, 0xa0a6000284264082L,
        0x1640000024003e21L, 0x4000047b98619202L, 0x1010000221008004L, 0x210808b342e380L,
        0x1c0e54ab1698f1b8L, 0xa7d487caf749b81L, 0x23734824141074ceL, 0x35242cd23040b82bL,
        0x40540001e9008810L, 0x2388228861e8a2beL, 0x9b929260000289e1L, 0x32a4231b5d222892L,
        0x49d800138e4001a8L, 0x8100003056900043L, 0x124002840c925dL, 0x104013835471008L,
        0x20082c0087002821L, 0x400000400192808L, 0x430e55201161042aL, 0x4630c82001890804L,
        0x410260400238002aL, 0xc1c09727a4840121L, 0xcc27000403229067L, 0xc05064815b488010L,
        0x809609e98002611fL, 0xb247810070508a65L, 0x5880378100638221L, 0x1db5346df62582e1L,
        0x2ab140d286881640L, 0x6ddea04050acc20L, 0x3152ded40244880L, 0xcb5900048e441300L,
        0x8104790151300187L, 0x900d8a818c081402L, 0x7054a5916d967046L, 0xa422228ba1012ab2L,
        0xae348df8e01bb461L, 0x3e1b821272827644L, 0x411079301fecb7L, 0x13164aec8c92810L,
        0x4c70201372126576L, 0x52340e660364805dL, 0x30cbba1800000000L, 0x0L,
        0x2a0L, 0x40ecc8181f2a5c0L, 0x37aa082618c322c4L, 0x46282c00c2509058L,
        0xde18a5c840801215L, 0x22022a36081bb47L, 0xf5812b4646d6820L, 0x1a0a02764c01488cL,
        0x27e0003010415042L, 0x212dc010612c8e1L, 0xb0a1142c98c094a7L, 0xa2c450e195a4183aL,
        0x65eea39b007a17c0L, 0x810000e52ab36382L, 0x142045061d50d4L, 0x400795b57105870L,
        0x3e42038810916ec0L, 0x8461a08000001518L, 0x5621223a0b04404L, 0x442a12898051e914L,
        0x191e1000a068448cL, 0x2420110725f4560L, 0x28108849400420d9L, 0x4a74c260000a0809L,
        0x82005da1420c0404L, 0xd0f205a010e40102L, 0x89a0c9580afb0060L, 0x4045840c0c600172L,
        0x2330132020058001L, 0x68c2b01104050L, 0x38140018718200L, 0xb560853084f00d2L,
        0xb2e460a804400911L, 0x5a154192a20a81L, 0x2004000120111034L, 0x8b10a00080012352L,
        0x407460071004250L, 0xaa0c31567090a507L, 0x609423422812cd01L, 0x7c010ccd408038ceL,
        0x2928b00604300290L, 0x580c02038a252903L, 0x53b113a043693025L, 0x8000202c13000880L,
        0xb0aa939514245a38L, 0x4280ec12b25ef008L, 0x2d4c54a2de8ca049L, 0x291d223aeb1651a2L,
        0xe90a8b74c2981042L, 0x404b02b90219e904L, 0x902ab26000000000L, 0x0L,
        0x121L, 0x42aa8420603800e8L, 0x246e0886e1ffbb9dL, 0xf9a6503aba24003cL,
        0xdb59a0000000000L, 0xb14d900L, 0x4420004010801022L, 0x2019023550b11409L,
        0xe1800700208c00L, 0x29e8844198002a08L, 0x4d3458404039c002L, 0x6bc20113010009eL,
        0x14683c5d026110d3L, 0x2e4e010978000000L, 0x1b1187e139L, 0x2c024820267589e4L,
        0xd617df67f10266caL, 0x6577fecad4c727adL, 0xf961400012a14480L, 0x4022001068840504L,
        0x200020400004a000L, 0x7e2a8034683580L, 0x2154a10828310ca0L, 0xc3dfc29d53000609L,
        0x64c0200480901L, 0xcd081322a004002L, 0x940056b800040140L, 0x12000086430a8L,
        0x20180e0b29b2430L, 0x8140a18800a040aL, 0x80b20010e8040L, 0x1080c3844c800000L,
        0x110098e0401006a0L, 0x48007032a020850fL, 0x4000000000000000L, 0x0L,
        0x0L, 0x100L, 0xb1715ac0bd84205aL, 0x112c0e8864000000L,
        0x840a32011L, 0xa81d801f3e28b7a4L, 0x6b70dd891a0ebd8L, 0xcf5e465830b0a350L,
        0x8ba7524a0920a0c6L, 0x2ac0224aead44868L, 0x4e15808892941800L, 0x1290100800063611L,
        0x7689f1a0480c099cL, 0x21f0c920111d800L, 0xa14200L, 0x1a0000192057280eL,
        0x1468b886c88a0006L, 0x2458e50000000000L, 0x3c0048e1808L, 0x4e80e49520066091L,
        0x4403304000908102L, 0xb40405312c700000L, 0x848088L, 0x8801588332374910L,
        0x20000a135e36018L, 0x7c0748a000010800L, 0x1002730180b60840L, 0x82616a107880e400L,
        0xaecbc104c07a072L, 0x380212081000280L, 0x0L, 0x5589a00L,
        0x13c2241112b80013L, 0x4a80c04ec8092020L, 0x1410020085128b0L, 0x6a011040020520e4L,
        0x3200000000L, 0x4c5L, 0x40987505066400fbL, 0x80fa8de84810b5cL,
        0x1821400c0080012L, 0x332801f3282300L, 0x4040c80000000L, 0x0L,
        0x0L, 0x0L, 0x0L, 0x0L,
        0x0L, 0x0L, 0x0L, 0x0L,
        0x0L, 0x0L, 0x0L, 0x0L,
        0x0L, 0x0L, 0x0L, 0x0L,
        0x0L, 0x0L, 0x0L, 0x0L,
        0x0L, 0x0L, 0x0L, 0x0L,
        0x0L, 0x0L, 0x0L, 0x0L,
        0x0L, 0x0L, 0x0L, 0x0L,
        0x0L, 0x0L, 0x0L, 0x0L,
        0x0L, 0x0L, 0x0L, 0x0L,
        0x0L, 0x0L, 0x0L, 0x0L,
        0x0L, 0x0L, 0x0L, 0x0L,
        0x0L, 0x0L, 0x0L, 0x0L,
        0x0L, 0x0L, 0x0L, 0x0L,
        0x0L, 0x0L, 0x0L, 0x0L,
        0x0L, 0x0L, 0x0L, 0x0L,
        0x0L, 0x0L, 0x0L, 0x0L,
        0x0L, 0x0L, 0x0L, 0x0L,
        0x0L, 0x0L, 0x0L, 0x0L,
        0x0L, 0x0L, 0x0L, 0x0L,
        0x0L, 0x0L, 0x0L, 0x0L,
        0x0L, 0x0L, 0x0L, 0x0L,
        0x0L, 0x0L, 0x0L, 0x0L,
        0x0L, 0x0L, 0x0L, 0x0L,
        0x0L, 0x0L, 0x0L, 0x0L,
        0x0L, 0x0L, 0x0L, 0x0L,
        0x0L, 0x0L, 0x0L, 0x0L,
        0x0L, 0x0L, 0x0L, 0x0L,
        0x0L, 0x0L, 0x0L, 0x0L,
        0x0L, 0x0L, 0x0L, 0x0L,
        0x0L, 0x0L, 0x0L, 0x0L,
        0x0L, 0x0L, 0x0L, 0x0L,
        0x0L, 0x0L, 0x0L, 0x0L,
        0x0L, 0x0L, 0x0L, 0x0L,
        0x0L, 0x0L, 0x0L, 0x0L,
        0x0L, 0x0L, 0x0L, 0x0L,
        0x0L, 0x0L, 0x0L, 0x0L,
        0x0L, 0x0L, 0x0L, 0x0L,
        0x0L, 0x0L, 0x0L, 0x0L,
        0x0L, 0x0L, 0x0L, 0x0L,
        0x0L, 0x0L, 0x0L, 0x0L,
        0x0L, 0x0L, 0x0L, 0x0L,
        0x0L, 0x0L, 0x0L, 0x0L,
        0x0L, 0x0L, 0x0L, 0x0L,
        0x0L, 0x0L, 0x0L, 0x0L,
        0x0L, 0x0L, 0x0L, 0x0L,
        0x0L, 0x0L, 0x0L, 0x0L,
        0x0L, 0x0L, 0x0L, 0x0L,
        0x0L, 0x0L, 0x0L, 0x0L,
        0x0L, 0x0L, 0x0L, 0x0L,
        0x0L, 0x0L, 0x0L, 0x0L,
        0x0L, 0x0L, 0x0L, 0x0L,
        0x0L, 0x0L, 0x0L, 0x0L,
        0x0L, 0x0L, 0x0L, 0x0L,
        0x0L, 0x0L, 0x0L, 0x0L,
        0x0L, 0x0L, 0x0L, 0x0L,
        0x0L, 0x0L, 0x0L, 0x0L,
        0x0L, 0x0L, 0x0L, 0x0L,
        0x0L, 0x0L, 0x0L, 0x0L,
        0x0L, 0x0L, 0x0L, 0x0L,
        0x0L, 0x0L, 0x0L, 0x0L,
        0x0L, 0x0L, 0x0L, 0x0L,
        0x0L, 0x0L, 0x0L, 0x0L,
        0x0L, 0x0L, 0x0L, 0x0L,
        0x0L, 0x0L, 0x0L, 0x0L,
        0x0L, 0x0L, 0x0L, 0x0L,
        0x0L, 0x0L, 0x0L, 0x0L,
        0x0L, 0x0L, 0x0L, 0x0L,
        0x0L, 0x0L, 0x0L, 0x0L,
        0x0L, 0x0L, 0x0L, 0x0L,
        0x0L, 0x0L, 0x0L, 0x0L,
        0x0L, 0x0L, 0x0L, 0x0L,
        0x0L, 0x0L, 0x0L, 0x0L,
        0x0L, 0x0L, 0x0L, 0x0L,
        0x0L, 0x0L, 0x0L, 0x0L,
        0x0L, 0x0L, 0x0L, 0x0L,
        0x0L, 0x0L, 0x0L, 0x0L,
        0x0L, 0x0L, 0x0L, 0x0L,
        0x0L, 0x0L, 0x0L, 0x0L,
        0x0L, 0x0L, 0x0L, 0x0L,
        0x0L, 0x0L, 0x0L, 0x0L,
        0x0L, 0x0L, 0x0L, 0x0L,
        0x0L, 0x0L, 0x0L, 0x0L,
        0x0L, 0x0L, 0x0L, 0x0L,
        0x0L, 0x0L, 0x0L, 0x0L,
        0x0L, 0x0L, 0x0L, 0x0L,
        0x0L, 0x0L, 0x0L, 0x0L,
        0x0L, 0x0L, 0x0L, 0x0L,
        0x0L, 0x0L, 0x0L, 0x0L,
        0x0L, 0x0L, 0x0L, 0x0L,
        0x0L, 0x0L, 0x0L, 0x0L,
        0x0L, 0x0L, 0x0L, 0x0L,
        0x0L, 0x0L, 0x0L, 0x0L,
        0x0L, 0x0L, 0x0L, 0x0L,
        0x0L, 0x0L, 0x0L, 0x0L,
        0x5efbffffffffffffL, 0xfffffffc7fffffffL, 0xffffffff00000000L, 0x0L
    };

    public ShiftJISCharacterSet() {
    }

    // Determine if it is a valid character
    public final boolean inCharset(int ch) {
        if (ch > 65535) {
            return false;
        }
        long g = flags[ch >> 6];
        long h = (g >> (63 - (ch & 0x3f))) & 1L;
        return h == 1L;
    }

    public final String getEncodingName() {
        // Canonical Name for java.io and java.lang API
        return "SJIS";
    }


}