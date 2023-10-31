;;; Sierra Script 1.0 - (do not remove this comment)
;
; * SCI Game Header
; *************************************************************************
; * Put all the defines specific to your game in here
(include system.sh) (include sci.sh)

(enum
	iNecklace		;0
	iMonocle		;1
	iLantern		;2
	iOilcan			;3
	iRollingPin		;4
	iSkeletonKey	;5
	iPoker			;6
	iCrowbar		;7
	iCigarButt		;8
	iBrokenRecord	;9
	iNotebook		;10
	iCrackers		;11
	iSoupBone		;12
	iValveHandle	;13
	iBullet			;14
	iDerringer		;15
	iMatches		;16
	iCarrot			;17
	iBrassKey		;18
	iDiary			;19
	iCrank			;20
	iCane			;21
	iPouch			;22
	iHandkerchief	;23
)

;Memory sizes
(define InvSize 2048)

(define SaveSize 1200)
(define GaugeSize 2048)

;Regions
(define ETHEL_DRUNK 202)
(define OUTSIDE 208)
(define DEAD_WILBUR 256)
(define LILLREAD 257)
(define WALKABOUT 381)
(define BARKING 400)
(define SCUFFING 401)
(define RUDYEAT 403)
(define GATOR 405)
(define CLOCK 406)

;Game acts
(enum
	actI
	actII
	actIII
	actIV
	actV
	actVI
	actVII
)

;Talkers
(enum 1
	talkGERTIE		;1
	talkCELIE		;2
	talkGLORIA		;3
	talkETHEL		;4
	talkFIFI		;5
	talkLILLIAN		;6
	talkCLARENCE	;7
	talkWILBUR		;8
	talkRUDY		;9
	talkCOLONEL		;10
	talkJEEVES		;11
	talkLAURA		;12
)
(define talkDADDY 26)

;Event flags
(define fSawShadowyFigure 0)
(define fOpenedFloorboard	1)
(define fReadDiary 3)
(define fGotMonocle	5)
(define fExaminedHandkerchief 6)
(define fExaminedRollingPin 7)
(define fExaminedPoker 8)
(define fExaminedRecord 9)
(define fExaminedGlass	10)
(define fExaminedDiary 12)
(define fExaminedCigar 13)
(define fGotBible		14)
(define fExaminedMagazine 17)
(define fSawFifiJeevesTogether 22)
(define fFlag36	36)
(define fSawLillianColonelTogether	38)
(define fDaddyTip1 41)
(define fDaddyTip2 42)
(define fDaddyTip3 43)
(define fLookedAtDog	49)
(define fSkippedIntro 50)
(define fSawDeadGuest 51)
(define fPnCVolumeFlag 52)
(define fPnCSaveFlag 53)
(define fCursorHidden 54)
;Murdered guests
(define deadGERTRUDE	$0001)
(define deadWILBUR		$0002)
(define deadGLORIA		$0004)
(define deadETHEL		$0008)
(define deadFIFI		$0010)
(define deadRUDY		$0020)
(define deadLILLIAN		$0040)


;howFast values
(enum
	slow
	medium
	fast
)
