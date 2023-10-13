;;; Sierra Script 1.0 - (do not remove this comment)
;;; Decompiled by sluicebox
(script# 995)
(include sci.sh)
(use Main)
(use Interface)
(use System)

(local
	yesI
	useMonocleI
	useToggle
	useI
)

(class InvI of Object
	(properties
		said 0
		description 0
		owner 0
		view 0
		loop 0
		cel 0
		script 0
	)

	(method (saidMe)
		(Said said)
	)

	(method (ownedBy id)
		(return (== owner id))
	)

	(method (moveTo id)
		(= owner id)
		(return self)
	)

	(method (showSelf)
		(ShowView (if description description else name) view loop cel)
	)

	(method (changeState newState)
		(if script
			(script changeState: newState)
		)
	)
)

(class Inv of Set
	(properties
		carrying {}
		empty {You are carrying nothing!}
	)

	(method (init)
		(= inventory self)
	)

	(method (saidMe)
		(self firstTrue: #saidMe)
	)

	(method (ownedBy whom)
		(self firstTrue: #ownedBy whom)
	)

	(method (showSelf whom)
		(invD text: carrying doit: whom)
	)
)

(instance invD of Dialog
	(properties)

	(method (init param1 &tmp temp0 temp1 temp2 temp3 temp4 temp5 temp6)
		(= temp2 (= temp0 (= temp1 4)))
		(= temp3 0)
		(for
			((= temp5 (inventory first:)))
			temp5
			((= temp5 (inventory next: temp5)))
			
			(= temp6 (NodeValue temp5))
			(if (temp6 ownedBy: param1)
				(++ temp3)
				(self
					add:
						((= temp4 (DText new:))
							value: temp6
							text: (temp6 name:)
							nsLeft: temp0
							nsTop: temp1
							state: 3
							font: smallFont
							setSize:
							yourself:
						)
				)
				(if (< temp2 (- (temp4 nsRight:) (temp4 nsLeft:)))
					(= temp2 (- (temp4 nsRight:) (temp4 nsLeft:)))
				)
				(if
					(>
						(+= temp1 (+ (- (temp4 nsBottom:) (temp4 nsTop:)) 1))
						140
					)
					(= temp1 4)
					(+= temp0 (+ temp2 10))
					(= temp2 0)
				)
			)
		)
		(if (not temp3)
			(self dispose:)
			(return 0)
		)
		(= window gMyWindow)
		(self setSize:)
		(= yesI (DButton new:))
		(yesI
			text: {OK}
			setSize:
			moveTo: (- nsRight (+ 4 (yesI nsRight:))) nsBottom
		)
		(yesI move: (- (yesI nsLeft:) (yesI nsRight:)) 0)
		(= useI (DButton new:))
		(useI 
			text: "Use_", ;English
			setSize:,
			moveTo: (- nsRight (+ 40 (useI nsRight:))) nsBottom
		)	
		(useI move: (- (useI nsLeft:) (useI nsRight:)) 0)		
		(if
			(and
				(ego has: 1) ; has monocle
				(not useToggle)
			)
			(= useMonocleI (DButton new:))
			(useMonocleI
				text: {Use Monocle}
				setSize:
				moveTo: (- nsRight (+ 4 (useMonocleI nsRight:))) (+ nsBottom 14)
			)
			;(useMonocleI move: (- (useMonocleI nsLeft:) (useMonocleI nsRight:)) 0)
		(= useI (DButton new:))
		(useI 
			text: "Use_", ;English
			setSize:,
			moveTo: 
				moveTo: (- nsRight (+ 4 (useI nsRight:))) nsBottom
		)			
			(useI move: (- (useI nsLeft:) (useI nsRight:)) 0)
			(self add: useI setSize: center:)			
			
			
			(= yesI (DButton new:))
			(yesI
				text: {OK}
				setSize:
				moveTo: (- (useMonocleI nsRight:) (yesI nsRight:)) nsBottom
			)
			(yesI move: (- (yesI nsLeft:) (yesI nsRight:)) 0)
			(self add: yesI useMonocleI setSize: center:)
		else
		(= useI (DButton new:))
		(useI 
			text: "Use_", ;English
			setSize:,
			moveTo: 
				moveTo: (- nsRight (+ 4 (useI nsRight:))) nsBottom
		)		
		
			(useI move: (- (useI nsLeft:) (useI nsRight:)) 0)
;;;			(self add: useI setSize: center:)		
			(= useI (DButton new:))
			(yesI
				text: {OK}
				setSize:
				moveTo: (- nsRight (+ 4 (yesI nsRight:))) nsBottom
			)
			(yesI move: (- (yesI nsLeft:) (yesI nsRight:)) 0)
			(self add: yesI useI setSize: center:)
		)
		(return temp3)
	)

	(method (doit param1 &tmp temp0 [str 200])
		(cond
			((== param1 777) ;inv use hack
				(= useToggle 1)
				(= useInvItem 0)
				(= useInvItem2 0)
				(= param1 ego)
			)
			((== param1 888) ;inv on inv from right-click ego
				(= useToggle 0)
				(= useInvItem 0)
				(= useInvItem2 0)
				(= param1 ego)
			)
			(else
				(= useToggle 0)
			)
		)
		(ego get: 0 2 3 4 5 6 18)
		(if (not (self init: param1))
			(Print (inventory empty:))
			(return)
		)
		(self open: 4 15)
		(= temp0 yesI)
		(repeat
			(if
				(or
					(not (= temp0 (super doit: temp0)))
					(== temp0 -1)
					(== temp0 yesI)
				)
				(break)
			)
			(if useToggle
				(= useInvItem ((temp0 value:) name?))
				(break)
			else
				(if (== temp0 useMonocleI)
					(= useInvItem2 {monocle })
					(Print {Select item to examine.})
				else
					(if (== useInvItem2 0)
						((temp0 value:) showSelf:)
					else
						(= useInvItem ((temp0 value:) name?))
						(break)
					)	
				)	
			)
		)
		(if (== temp0 yesI)
			(= useInvItem 0)
		)
		(self dispose:)
	)

	(method (handleEvent event &tmp temp0 temp1)
		(= temp0 (event message:))
		(switch (= temp1 (event type:))
			(evKEYBOARD
				(switch temp0
					(KEY_UP
						(= temp0 KEY_SHIFTTAB)
					)
					(KEY_DOWN
						(= temp0 KEY_TAB)
					)
				)
			)
			($0040 ; direction
				(switch temp0
					(JOY_UP
						(= temp0 KEY_SHIFTTAB)
						(= temp1 evKEYBOARD)
					)
					(JOY_DOWN
						(= temp0 KEY_TAB)
						(= temp1 evKEYBOARD)
					)
				)
			)
		)
		(event type: temp1 message: temp0)
		(super handleEvent: event)
	)
)

