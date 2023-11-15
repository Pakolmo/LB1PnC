;;; Sierra Script 1.0 - (do not remove this comment)
(script# 354)
(include game.sh)
(use Main)
(use Intrface)
(use Sound)
(use Motion)
(use Game)
(use Actor)
(use System)

(public
	scene42e 0
)

(local
	theCycles
	mouthCued
	saveBits
	local3 =  1
	temp7
)
(procedure (Measure &tmp [temp0 500])
	(GetFarText &rest @temp0)
	(= theCycles (+ (/ (StrLen @temp0) 3) 1))
)

(procedure (LillPrint)
	(Measure &rest)
	(= theCycles (+ theCycles (/ theCycles 4)))
	(lillMouth setScript: cycleMouth)
	(Print
		&rest
		#at
		160
		115
		#font
		4
		#width
		140
		#mode
		1
		#dispose
	)
)

(procedure (ColoPrint)
	(Measure &rest)
	(= theCycles (+ theCycles (/ theCycles 2)))
	(coloMouth loop: 5 setScript: cycleMouth)
	(Print &rest
		#at 20 115
		#font 4
		#width 140
		#mode teJustCenter
		#dispose
	)
)

(instance Hand of Actor)

(instance Smoke of Actor)

(instance Colonel of Prop)

(instance coloFace of Prop)

(instance coloMouth of Prop)

(instance coloEyes of Prop)

(instance myMusic of Sound)

(instance scene42e of Room
	(properties
		picture 62
		style IRISOUT
	)
	
	(method (init)
		(super init:)
		(Load FONT 4)
		(HandsOff)
		(myMusic number: 27 loop: -1 play:)
		(Colonel
			view: 311
			posn: 101 105
			loop: 1
			cel: 0
			setPri: 1
			init:
			stopUpd:
		)
		(coloFace
			view: 311
			posn: 114 88
			loop: 0
			cel: 0
			setPri: 2
			init:
			stopUpd:
		)
		(coloEyes
			view: 311
			posn: 114 (- (coloFace y?) 15)
			loop: 2
			cel: 0
			setPri: 3
			setScript: ColoEyes
			init:
			stopUpd:
		)
		(coloMouth
			view: 311
			posn: 114 88
			loop: 4
			cel: 0
			setPri: 2
			cycleSpeed: 1
			init:
			hide:
		)
		(Hand
			view: 311
			posn: 128 136
			setLoop: 1
			setCel: 1
			setPri: 3
			moveSpeed: 1
			illegalBits: 0
			ignoreActors: TRUE
			init:
			hide:
		)
		(Smoke
			view: 311
			setLoop: 3
			setCycle: Walk
			setPri: 3
			illegalBits: 0
			ignoreActors: 1
			init:
			hide:
		)
		(if (and (not (& global173 $0040)) (!= [global368 1] 1))
			(= [global368 1] 1)
;;;			(|= global173 $0040)
			(= global173 (| global173 $0040))
			(Load FONT 41)
			(LoadMany 143 406)
			(Load VIEW 642)
			(LoadMany SOUND 94 95 96 29)
			(Lillian setPri: 3 cycleSpeed: 2 init:)
			(lillMouth cycleSpeed: 1 setPri: 4 init: hide:)
			(lillEye setPri: 4 init: setScript: LillEyes)
			(Bset 38)
			(self setScript: speech42e)
		else
			(self setScript: twice)
		)
	)
	
	(method (doit)
		(super doit:)
	)
	
	(method (dispose)
		(super dispose:)
	)
	
	(method (handleEvent event)
		(super handleEvent: event)
	)
)

(instance speech42e of Script
	
	(method (doit)
		(super doit:)
	)
	
	(method (changeState newState)
		(if (cycleMouth client?)
			(= mouthCued 1)
			(= cycles 1)
		else
			(switch (= state newState)
				(0
					(cond 
						((not global216)
							(= state -1)
						)
						((not (& global118 $0002))
;;;							(|= global118 $0002)
							(= global118 (| global118 $0002))							
							(self setScript: (ScriptID 406 0))
							(= state -1)
						)
						((self script?)
							(= state -1)
						)
					)
					(= cycles 1)
				)
				(1
					(= saveBits
						(Display 354 0
							p_at 48 8
							p_width 256
							p_color vWHITE
							p_back -1
							p_font SYSFONT
							p_save
						)
					)
					(LillPrint 354 1)
					(= seconds 10)
				)
				(2
					(ColoPrint 354 2)
					(= seconds 8)
				)
				(3
					(Colonel setScript: twice)
					(LillPrint 354 3)
					(= seconds 10)
				)
				(4
					(if (Colonel script?)
						(= state 3)
						(= cycles 1)
					else
						(ColoPrint 354 4)
						(= seconds 5)
					)
				)
				(5
					(LillPrint 354 5)
					(= seconds 8)
				)
				(6
					(ColoPrint 354 6)
					(= seconds 10)
				)
				(7
					(Colonel setScript: twice)
					(LillPrint 354 7)
					(= seconds 10)
				)
				(8
					(if (Colonel script?)
						(= state 7)
						(= cycles 1)
					else
						(LillPrint 354 8)
						(= seconds 5)
					)
				)
				(9
					(Lillian
						setLoop: 4
						setCycle: Walk
						setMotion: MoveTo 300 (Lillian y?) self
					)
					(lillEye dispose:)
				)
				(10
					(curRoom newRoom: prevRoomNum)
				)
			)
		)
	)
	
	(method (handleEvent event)
		(super handleEvent: event)
		(if
			(and
				(not (event claimed?))
				(not script)
				(== keyDown (event type?))
				(or
					(== (event message?) `S)
					(== (event message?) `s)
				)
			)
			(cls)
			(curRoom newRoom: prevRoomNum)
		)
		(if (== evMOUSEBUTTON (event type:))
			(= temp7
				(Print {Skip scene?}
					#button {Yes} 1
					#button {No} 0
				)
			)
			(if (== temp7 1)
				(cls)
				(curRoom newRoom: prevRoomNum)
			)
		)			
	)
)

(instance cycleMouth of Script
	
	(method (doit)
		(super doit:)
		(if mouthCued
			(= mouthCued FALSE)
			(= cycles 1)
		)
	)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(client cel: 0 setCycle: Forward show:)
				(= cycles theCycles)
			)
			(1
				(client setScript: 0 hide:)
				(self client: 0)
			)
		)
	)
)

(instance ColoEyes of Script

	(method (changeState newState)
		(switch (= state newState)
			(0 (= cycles 7))
			(1
				(= state 0)
				(if (^= local3 $0001)
					(coloEyes hide:)
					(= seconds (Random 2 3))
				else
					(coloEyes
						cel: (/ (Random 1 29999) 10000)
						forceUpd:
						show:
					)
					(= cycles 3)
				)
			)
		)
	)
)

(instance LillEyes of Script

	(method (changeState newState)
		(switch (= state newState)
			(0
				(= cycles 7)
			)
			(1
				(= state 0)
				(lillEye loop: (Random 2 3) cel: 0 setCycle: BegLoop)
				(= seconds (Random 3 8))
			)
		)
	)
)

(instance twice of Script

	(method (doit)
		(super doit:)
		(if
			(and
				(== state 3)
				(== (Smoke cel?) (- (NumCels Smoke) 1))
			)
			(Smoke hide:)
		)
	)
	
	(method (changeState newState)
		(switch (= state newState)
			(0
				(if (== client scene42e)
					(Print 354 9 #dispose)
				)
				(coloFace cel: 0 forceUpd:)
				(coloEyes y: (- (coloFace y?) 15) forceUpd:)
				(Hand show: setMotion: MoveTo 116 116 self)
			)
			(1
				(Hand stopUpd:)
				(coloMouth show: loop: 4 setCycle: Forward)
				(= seconds 3)
			)
			(2
				(coloMouth setCycle: EndLoop)
				(Hand setMotion: MoveTo 128 136 self)
			)
			(3
				(Hand hide:)
				(coloFace cel: 1 forceUpd:)
				(coloMouth hide:)
				(coloEyes y: (- (coloFace y?) 16) forceUpd:)
				(Smoke
					show:
					cel: 0
					posn: 113 79
					setMotion: MoveTo 128 101 self
				)
			)
			(4
				(if (== client scene42e)
					(curRoom newRoom: prevRoomNum)
				else
					(coloFace cel: 0 forceUpd:)
					(coloEyes y: (- (coloFace y?) 15) forceUpd:)
					(client setScript: 0)
					(self client: 0)
				)
			)
		)
	)
)

(instance Lillian of Actor
	(properties
		y 107
		x 227
		view 504
	)
)

(instance lillMouth of Prop
	(properties
		y 85
		x 214
		view 504
		loop 1
	)
)

(instance lillEye of Prop
	(properties
		y 72
		x 207
		view 504
		loop 2
	)
)
