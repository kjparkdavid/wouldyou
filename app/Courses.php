

<?php namespace App;
use Illuminate\Database\Eloquent\Model;

class Courses extends Model {
	/** Properties **/
	protected $fillable = array('name','image','category');
	public static $rules = array();
	/** Enable softDeleting **/
	//use SoftDeletingTrait;
	/**
	*	TYPE 1 = EXPERIENCE
	* TYPE 2 = VOLUNTEER
	*	TYPE 3 = EDUCATION
	**/
	/** Relations **/
	public function course_details() {
		return $this->hasMany('CourseDetails');
	}
}
