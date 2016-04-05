<?php namespace App;
use Illuminate\Database\Eloquent\Model;
class CourseDetails extends Eloquent {
	/** Properties **/
	protected $fillable = array('name','course_id','image','category');
	public static $rules = array();

	 protected $table = 'course_details';
	/** Enable softDeleting **/
	//use SoftDeletingTrait;
	/**
	*	TYPE 1 = EXPERIENCE
	* TYPE 2 = VOLUNTEER
	*	TYPE 3 = EDUCATION
	**/
	/** Relations **/
	public function courses() {
		return $this->belongsTo('Courses');
	}
}
